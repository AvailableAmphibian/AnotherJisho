package hf.dra.anotherjisho.service

import hf.dra.anotherjisho.Constants.QUERY_WORDS
import hf.dra.anotherjisho.models.TranslationRequest
import hf.dra.anotherjisho.models.Word
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceJisho {
    @GET(QUERY_WORDS)
    fun getTranslations(@Query("keyword") keyword:String): Call<TranslationRequest>
}