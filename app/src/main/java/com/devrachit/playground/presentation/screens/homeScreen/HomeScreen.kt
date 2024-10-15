package com.devrachit.playground.presentation.screens.homeScreen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devrachit.playground.R
import com.devrachit.playground.common.Constants.Companion.blogData
import com.devrachit.playground.presentation.components.BlogItem
import com.devrachit.playground.ui.theme.GrayShade4

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onClick: (String) -> Unit) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .background(color = colorResource(id = R.color.background)),
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
                icon = {
                    Icon(
                        Icons.Filled.Menu, contentDescription = null, tint = colorResource(
                            R.color.teal_700
                        )
                    )
                },
                text = { Text("Some Navigation") },
                onClick = { },
                containerColor = Color.White,
                contentColor = Color.Black
            )
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        MyApp(
            modifier = Modifier.padding(innerPadding),
            paddingValues = innerPadding,
            onClick = onClick
        )
    }
}

@Composable
fun MyApp(
    modifier: Modifier? = Modifier,
    paddingValues: PaddingValues = PaddingValues(0.dp),
    onClick: (String) -> Unit
) {


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
    ) {
        items(blogData.size) { i ->
            BlogItem(
                imageUrl = blogData[i].imageUrl,
                title = blogData[i].title,
                date = blogData[i].data,
                onItemClick = { onClick(blogData[i].route ?: "home") },
            )
        }
    }
}


//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Composable
//fun GreetingPreview() {
//
//    MyApp()
//
//}
//
//
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
//@Composable
//fun GreetingPreview2() {
//    MyApp()
//}