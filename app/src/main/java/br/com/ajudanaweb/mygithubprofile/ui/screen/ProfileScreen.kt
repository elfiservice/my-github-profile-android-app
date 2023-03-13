package br.com.ajudanaweb.mygithubprofile.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ajudanaweb.mygithubprofile.ui.theme.MyGithubProfileTheme
import br.com.ajudanaweb.mygithubprofile.webclient.GitHubWebClient
import coil.compose.AsyncImage
import br.com.ajudanaweb.mygithubprofile.R

@Composable
fun ProfileScreen(
    user: String,
    webClient: GitHubWebClient = GitHubWebClient()
) {
    val foundUser by webClient.findProfileBy(user)
        .collectAsState(initial = null)
    foundUser?.let { userProfile ->
        Column() {
            val boxHeight = remember {
                150.dp
            }
            val imageHeight = remember {
                boxHeight
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xFF2d333b),
                        shape = RoundedCornerShape(
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .height(boxHeight)

            ) {
                AsyncImage(
                    userProfile.avatar,
                    contentDescription = "My image profile",
                    placeholder = painterResource(R.drawable.user_placeholder),
                    modifier = Modifier
                        .offset(y = imageHeight / 2)
                        .size(imageHeight)
                        .align(Alignment.BottomCenter)
                        .clip(CircleShape),
                )
            }
            Spacer(modifier = Modifier.height(imageHeight / 2))
            Column(
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = userProfile.name,
                    style = MaterialTheme.typography.h4
                )
                Text(text = userProfile.login,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold)
                Text(text = userProfile.bio,
                    Modifier
                        .padding(
                            start = 8.dp,
                            bottom = 8.dp,
                            end = 8.dp
                        )
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyGithubProfileTheme {
        ProfileScreen("elfiservice")
    }
}