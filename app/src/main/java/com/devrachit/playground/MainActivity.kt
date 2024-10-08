package com.devrachit.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devrachit.playground.ui.theme.PlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaygroundTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier =Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier:Modifier?= null){
    PlaygroundTheme {
        Text(
            text = "Hello, World!",
            color= colorResource(id = R.color.teal_700),
            modifier = modifier?.padding(16.dp).let { it ?: Modifier.padding(16.dp) })
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlaygroundTheme {

    }
}