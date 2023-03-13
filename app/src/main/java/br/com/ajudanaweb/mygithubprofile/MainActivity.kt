package br.com.ajudanaweb.mygithubprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import br.com.ajudanaweb.mygithubprofile.ui.screen.ProfileScreen
import br.com.ajudanaweb.mygithubprofile.ui.theme.MyGithubProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

/*        lifecycleScope.launch {
            RetrofitInit().gitHubService.findProfileBy("elfiservice")
                .let {
                    Log.i("MainActivity", "onCreate: $it")
                }
        }*/

        setContent {
            MyGithubProfileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProfileScreen("elfiservice")
                }
            }
        }
    }
}