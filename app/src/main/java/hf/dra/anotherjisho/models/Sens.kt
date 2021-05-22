package hf.dra.anotherjisho.models

import com.google.gson.annotations.SerializedName

data class Sens(
    @SerializedName("english_definitions") val englishDefinitions: List<String>,
    @SerializedName("parts_of_speech") val partsOfSpeech: List<String>,
    val links: List<Link>,
    val tags: List<String>,
    val restrictions: List<String>,
    @SerializedName("see_also") val seeAlso: List<String>,
    val antonyms: List<String>,
    val source: List<String>,
    val info: List<String>
)
