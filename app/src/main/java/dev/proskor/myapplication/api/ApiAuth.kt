package dev.proskor.myapplication.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dev.proskor.myapplication.models.GitUser
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiAuth {
    @GET("user")
    @Headers("Accept: application/json")
    fun getUser(@Header("Authorization") token: String): Call<GitUser>

    companion object {
        var BASE_URL = "https://api.github.com/"
        fun create(baseurl: String): ApiAuth {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiAuth::class.java)
        }
    }
}