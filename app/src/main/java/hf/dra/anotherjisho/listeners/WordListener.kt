package hf.dra.anotherjisho.listeners

import hf.dra.anotherjisho.models.Word

interface WordListener {
    fun onClickWord(word: Word)
}
