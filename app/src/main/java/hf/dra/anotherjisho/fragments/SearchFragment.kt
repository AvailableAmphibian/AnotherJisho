package hf.dra.anotherjisho.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hf.dra.anotherjisho.MainActivity
import hf.dra.anotherjisho.databinding.FragmentSearchBinding

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
        val queriedResults: List<String> = ArrayList()

        //Query has no result
        //TODO Add dialog fragment
        if (queriedResults.isEmpty()) {
            Log.i(TAG, "onClickSearch: No results in query")
            return
        }

        val fragment: Fragment

        //Query has one result
        if (queriedResults.size == 1) {
            Log.i(TAG, "onClickSearch: One result in query")
            fragment = DetailedFragment()
            (requireActivity() as MainActivity).showFragment(fragment, DetailedFragment.TAG)
            return
        }

        //Query has multiple results
        Log.i(TAG, "onClickSearch: Multiple results in query")
        fragment = MultipleResultsFragment()
        (requireActivity() as MainActivity).showFragment(fragment, MultipleResultsFragment.TAG)

    }
}