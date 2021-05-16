package hf.dra.anotherjisho.fragments

import androidx.fragment.app.Fragment
import hf.dra.anotherjisho.databinding.FragmentDetailedBinding

class DetailedFragment: Fragment() {
    private val binding by lazy { FragmentDetailedBinding.inflate(layoutInflater) }
    companion object { val TAG = DetailedFragment::class.java.simpleName }
}