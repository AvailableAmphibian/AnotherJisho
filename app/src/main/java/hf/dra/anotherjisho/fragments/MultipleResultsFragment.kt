package hf.dra.anotherjisho.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import hf.dra.anotherjisho.adapters.WordsAdapter
import hf.dra.anotherjisho.databinding.FragmentMultipleResultsBinding
import hf.dra.anotherjisho.models.Word

class MultipleResultsFragment(private val words: List<Word>) : Fragment() {
    companion object {
        val TAG = MultipleResultsFragment::class.java.simpleName
    }

    private val binding by lazy { FragmentMultipleResultsBinding.inflate(layoutInflater) }
    private val adapter by lazy { WordsAdapter(requireContext(), words) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.fragment = this

        configRecyclerView()

        return binding.root
    }

    private fun configRecyclerView() {
        binding.rvQueryResults.adapter = adapter
        binding.rvQueryResults.layoutManager = LinearLayoutManager(requireContext())
    }

    fun onClickButton(v: View) {
        requireActivity().onBackPressed()
    }
}