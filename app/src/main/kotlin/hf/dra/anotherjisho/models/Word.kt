package hf.dra.anotherjisho.models

import android.view.View
import com.google.gson.annotations.SerializedName

data class Word(
    val slug:String,
    @SerializedName("is_common") val isCommon:Boolean,
    val tags:List<String>,
    val jlpt:List<String>,
    val japanese:List<JapaneseWord>,
    val senses:List<Sens>,
){
    fun showFirstTag() = tags[0]
    fun showFirstJlpt() = jlpt[0]
    private fun showFirstJapanese() = japanese[0]
    fun showFirstSense() = senses[0]

    fun showFirstWordReading() = if (showFirstJapanese().word == null) "" else showFirstJapanese().reading
    fun showFirstWord() = showFirstJapanese().word ?: showFirstJapanese().reading
    fun hideReadingContainer() = if(showFirstJapanese().word == null) View.GONE else View.VISIBLE

    fun showCommonTag() = if(isCommon) View.VISIBLE else View.GONE
    fun showJlptTag() = if(jlpt.isNotEmpty()) View.VISIBLE else View.GONE
    fun showOtherTag() = if (tags.isNotEmpty()) View.VISIBLE else View.GONE
}