package hf.dra.anotherjisho.adapters

import androidx.recyclerview.widget.RecyclerView
import hf.dra.anotherjisho.databinding.HolderWordBinding
import hf.dra.anotherjisho.models.Word

class WordHolder(private val binding: HolderWordBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private lateinit var word: Word
    private var visible:Boolean = false

    init {
        binding.holder = this
    }

    fun bindTo(word: Word) {
        this.word = word
        binding.word = word
    }
}
