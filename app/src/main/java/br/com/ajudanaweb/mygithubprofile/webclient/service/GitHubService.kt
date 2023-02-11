package br.com.ajudanaweb.mygithubprofile.webclient.service

import br.com.ajudanaweb.mygithubprofile.webclient.model.GitHubProfileWeb
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("/users/{user}")
    suspend fun findProfileBy(@Path("user") user: String): GitHubProfileWeb

}