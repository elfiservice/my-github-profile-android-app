package br.com.ajudanaweb.mygithubprofile.webclient.model

import br.com.ajudanaweb.mygithubprofile.ui.screen.ProfileUiState
import com.squareup.moshi.Json

data class GitHubProfileWeb(
    val login: String,
    @field:Json(name = "avatar_url")
    val avatar: String,
    val name: String,
    val bio: String
)

fun GitHubProfileWeb.toProfileUiState(): ProfileUiState {
    return ProfileUiState(
        user = login,
        image = avatar,
        name = name,
        bio = bio
    )
}