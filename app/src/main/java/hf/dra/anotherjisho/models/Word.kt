package hf.dra.anotherjisho.models

data class Word(
    val slug:String,
    val isCommon:Boolean,
    val tags:List<String>,
    val jlpt:List<String>,
    val japanese:List<JapaneseWord>,
    val senses:List<Sens>,
    val attribution:Attribution
)