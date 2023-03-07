package br.com.ajudanaweb.mygithubprofile.webclient

import android.util.Log
import br.com.ajudanaweb.mygithubprofile.webclient.model.GitHubProfileWeb
import br.com.ajudanaweb.mygithubprofile.webclient.service.GitHubService
import kotlinx.coroutines.flow.flow

class GitHubWebClient(
    private val service: GitHubService = RetrofitInit().gitHubService
) {

    fun findProfileBy(user: String) = flow {
        try {
            emit(service.findProfileBy(user)) as GitHubProfileWeb
        } catch (e: Exception) {
            Log.e("GitHubWebClient", "findProfileBy: falha ao buscar usuário", e)
        }
    }

}