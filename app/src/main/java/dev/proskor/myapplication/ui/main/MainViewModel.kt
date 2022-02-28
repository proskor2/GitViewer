package dev.proskor.myapplication.ui.main

import android.media.session.MediaSession
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.proskor.myapplication.api.ApiRepos
import dev.proskor.myapplication.models.GitRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel() : ViewModel() {

    val repoList = MutableLiveData<List<GitRepository>>()
    val errorMessage = MutableLiveData<String>()

    fun getRepos() {
        val response = ApiRepos.create().getRepos("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", "proskor2" )
        response.enqueue(object : Callback<List<GitRepository>> {
            override fun onResponse(call: Call<List<GitRepository>>, response: Response<List<GitRepository>>) {
                repoList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<GitRepository>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}