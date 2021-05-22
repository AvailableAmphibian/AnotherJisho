package hf.dra.anotherjisho.dialog_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import hf.dra.anotherjisho.databinding.DialogLoadingBinding
import hf.dra.anotherjisho.fragments.SearchFragment

class LoadingDialog: DialogFragment() {
    val binding by lazy { DialogLoadingBinding.inflate(layoutInflater) }
    companion object {
        val TAG = LoadingDialog::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root
}