package br.com.ajudanaweb.mygithubprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import br.com.ajudanaweb.mygithubprofile.ui.theme.MyGithubProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGithubProfileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyBasicInformations()
                }
            }
        }
    }
}

@Composable
fun MyBasicInformations() {
    Row {
        Image(painter = painterResource(R.drawable.my_github_profile), contentDescription = "My image profile")
        Column() {
            Text(text = "Armando Jr.")
            Text(text = "elfiservice")
            Text(text = "Mobile developer at Descartes Inc.")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyGithubProfileTheme {
        MyBasicInformations()
    }
}