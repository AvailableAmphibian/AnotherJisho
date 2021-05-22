package hf.dra.anotherjisho.dialog_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import hf.dra.anotherjisho.databinding.DialogNoResultsBinding

class NoResultsDialog : DialogFragment() {
    val binding by lazy { DialogNoResultsBinding.inflate(layoutInflater) }

    companion object {
        val TAG = NoResultsDialog::class.java.simpleName
    }

    fun onClickButtonNoResults(v: View) = dismiss()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.dialog = this
        return binding.root
    }
}