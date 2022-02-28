package dev.proskor.myapplication.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dev.proskor.myapplication.models.GitRepository
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiRepos {
    @GET("users/{username}/repos")
    @Headers("Accept: application/json")
    fun getRepos(@Header("Authorization") token: String, @Path("username") username: String): Call<List<GitRepository>>

    companion object {
        var BASE_URL = "https://api.github.com/"
        fun create(): ApiRepos {
            val retrofit = Retrofit.Builder()
//                .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiRepos::class.java)
        }

    }
}