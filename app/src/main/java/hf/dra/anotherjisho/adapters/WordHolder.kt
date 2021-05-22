package hf.dra.anotherjisho.adapters

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import hf.dra.anotherjisho.databinding.HolderWordBinding
import hf.dra.anotherjisho.listeners.WordListener
import hf.dra.anotherjisho.models.Word

class WordHolder(private val binding: HolderWordBinding, val listener: WordListener) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var word:Word

    init {
        binding.holder = this
    }

    fun bindTo(word: Word) {
        this.word = word
        binding.word = word
    }

    fun onClickArrow(v: View){
        val visible = binding.moreDataContainer.isVisible

        binding.arrowTv.rotation = if (visible) 90F else 0F
        binding.moreDataContainer.visibility = if (visible) View.VISIBLE else View.GONE
    }

    fun onClickItem(v:View){
        listener.onClickWord(word)
    }
}
