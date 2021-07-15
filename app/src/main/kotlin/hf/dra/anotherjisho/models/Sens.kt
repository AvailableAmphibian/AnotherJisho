package hf.dra.anotherjisho.models

import com.google.gson.annotations.SerializedName

data class Sens(
    @SerializedName("english_definitions") val englishDefinitions: List<String>,
    @SerializedName("parts_of_speech") val partsOfSpeech: List<String>,
    @SerializedName("see_also") val seeAlso: List<String>,
){
    fun showDefinitions() = englishDefinitions.joinToString(", ")
    fun showPartsOfSpeech() = partsOfSpeech.joinToString(", ")

    fun firstPartOfSpeech() = partsOfSpeech[0]
}
