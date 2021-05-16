package hf.dra.anotherjisho.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hf.dra.anotherjisho.databinding.FragmentMultipleResultsBinding

class MultipleResultsFragment:Fragment() {
    companion object{
        val TAG = MultipleResultsFragment::class.java.simpleName
    }
    val binding by lazy { FragmentMultipleResultsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        return binding.root
    }
}