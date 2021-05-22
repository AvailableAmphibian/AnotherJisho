package hf.dra.anotherjisho.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hf.dra.anotherjisho.MainActivity
import hf.dra.anotherjisho.databinding.FragmentSearchBinding
import hf.dra.anotherjisho.dialog_fragments.NoResultsDialog
import hf.dra.anotherjisho.models.TranslationRequest
import hf.dra.anotherjisho.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {
    companion object {
        val TAG = SearchFragment::class.java.simpleName
    }

    private val binding by lazy { FragmentSearchBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.fragment = this
        return binding.root
    }

    fun onClickSearch(v: View) {
        //TODO Do query
        val query = binding.searchBar.text.toString()

        val results = RetrofitInstance
            .retrofit
            .getTranslations(keyword = query)

        (requireActivity() as MainActivity).showLoadingDialog()

        results.enqueue(object : Callback<TranslationRequest> {
            override fun onResponse(
                call: Call<TranslationRequest>,
                response: Response<TranslationRequest>
            ) {
                (requireActivity() as MainActivity).dismissLoadingDialog()

                if (!response.isSuccessful || response.body() == null)
                    return

                val status = response.body()!!.meta.status

                if (status != 200) {
                    Log.i(TAG, "onResponse: $status")
                }

                val queriedResults = response.body()!!.data

                //Query has no result
                //TODO Add dialog fragment
                if (queriedResults.isEmpty()) {
                    Log.i(TAG, "onClickSearch: No results in query")
                    val dialog = NoResultsDialog()
                    dialog.show(requireFragmentManager(), NoResultsDialog.TAG)
                    return
                }

                val fragment: Fragment

                //Query has one result
                if (queriedResults.size == 1) {
                    Log.i(TAG, "onClickSearch: One result in query")
                    fragment = DetailedFragment(queriedResults[0])
                    (requireActivity() as MainActivity).showFragment(fragment, DetailedFragment.TAG)
                    return
                }

                //Query has multiple results
                Log.i(TAG, "onClickSearch: Multiple results in query")
                fragment = MultipleResultsFragment(queriedResults)
                (requireActivity() as MainActivity).showFragment(
                    fragment,
                    MultipleResultsFragment.TAG
                )
            }

            override fun onFailure(call: Call<TranslationRequest>, t: Throwable) {
                (requireActivity() as MainActivity).dismissLoadingDialog()
                Log.e(TAG, "onFailure:", t)
            }

        })
    }
}