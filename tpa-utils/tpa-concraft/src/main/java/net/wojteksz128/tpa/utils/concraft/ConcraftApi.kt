package net.wojteksz128.tpa.utils.concraft

import com.google.gson.GsonBuilder
import net.wojteksz128.tpa.utils.concraft.api.ParseService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASEURL: String = "http://localhost:3000/"

object ConcraftApi {
    val parseService: ParseService

    init {
        val retrofit: Retrofit = createInstance()
        parseService = retrofit.create(ParseService::class.java)
    }

    private fun createInstance(): Retrofit {
        val gson = GsonBuilder()
                .setLenient()
                .create()
        val okHttpClient = OkHttpClient.Builder()
                .readTimeout(100, TimeUnit.SECONDS)
                .connectTimeout(100, TimeUnit.SECONDS)
                .build()
        return Retrofit.Builder()
                .baseUrl(BASEURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }
}