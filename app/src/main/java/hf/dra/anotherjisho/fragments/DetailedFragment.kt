package hf.dra.anotherjisho.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hf.dra.anotherjisho.databinding.FragmentDetailedBinding
import hf.dra.anotherjisho.models.Word

class DetailedFragment(private val word: Word): Fragment() {
    private val binding by lazy { FragmentDetailedBinding.inflate(layoutInflater) }
    companion object { val TAG = DetailedFragment::class.java.simpleName }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        return binding.root
    }
}