package com.devrachit.playground.presentation

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devrachit.playground.R
import com.devrachit.playground.common.Constants.Companion.blogData
import com.devrachit.playground.presentation.components.BlogItem
import com.devrachit.playground.ui.theme.GrayShade2
import com.devrachit.playground.ui.theme.GrayShade4
import com.devrachit.playground.ui.theme.PlaygroundTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
            PlaygroundTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(scrollBehavior.nestedScrollConnection)
                        .background(color = colorResource(id= R.color.background))
                    ,
                    topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = "Playground",
                                color = Color.White,
                                modifier = Modifier
                                    .padding(horizontal = 8.dp)
                            )
                        },
                        scrollBehavior = scrollBehavior,
                        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = colorResource(id = R.color.teal_700))
                    )
                },
                    snackbarHost = {
                        SnackbarHost(
                            hostState = snackbarHostState
                        )
                    },
                    floatingActionButton = {
                        ExtendedFloatingActionButton(
                            icon = { Icon(Icons.Filled.Menu, contentDescription = null, tint= colorResource(
                                R.color.teal_700
                            )) },
                            text = { Text("Some Navigation") },
                            onClick = {  },
                            containerColor = Color.White,
                            contentColor = Color.Black
                        )
                    },
                    floatingActionButtonPosition = FabPosition.Center
                    ) { innerPadding ->
                    MyApp(modifier =Modifier.padding(innerPadding),paddingValues= innerPadding)
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier:Modifier?= null , paddingValues: PaddingValues = PaddingValues(0.dp)){


    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 200.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(color = GrayShade4)
            .padding(horizontal = 24.dp),
        contentPadding = PaddingValues(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
            ){
        items(blogData.size) {i->
            BlogItem(
                imageUrl = blogData[i].imageUrl,
                title = blogData[i].title,
                date = blogData[i].data,
            )
        }
    }
}




@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun GreetingPreview() {

        MyApp()

}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun GreetingPreview2() {
    MyApp()
}