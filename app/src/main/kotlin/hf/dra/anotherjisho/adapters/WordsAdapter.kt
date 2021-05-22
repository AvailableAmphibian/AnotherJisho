package hf.dra.anotherjisho.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hf.dra.anotherjisho.databinding.HolderWordBinding
import hf.dra.anotherjisho.listeners.WordListener
import hf.dra.anotherjisho.models.Word

class WordsAdapter(
    private val context: Context,
    private val words: List<Word>,
    private val listener: WordListener
): RecyclerView.Adapter<WordHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        val binding = HolderWordBinding.inflate(LayoutInflater.from(context),parent,false)
        return WordHolder(binding, listener = listener)
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        holder.bindTo(words[position])
    }

    override fun getItemCount() = words.size
}