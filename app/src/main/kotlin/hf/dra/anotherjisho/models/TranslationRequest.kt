package hf.dra.anotherjisho.models

data class TranslationRequest(
    val meta:RequestCode,
    val data:List<Word>
)
