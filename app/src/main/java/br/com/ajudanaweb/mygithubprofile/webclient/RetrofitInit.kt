package br.com.ajudanaweb.mygithubprofile.webclient

import br.com.ajudanaweb.mygithubprofile.webclient.service.GitHubService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInit {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val gitHubService get() = retrofit.create(GitHubService::class.java)
}