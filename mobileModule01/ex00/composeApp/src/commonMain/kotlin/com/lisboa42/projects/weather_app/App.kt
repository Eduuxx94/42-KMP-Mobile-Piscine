package com.lisboa42.projects.weather_app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lisboa42.projects.weather_app.ui.PlaceholderTextField
import com.lisboa42.projects.weather_app.ui.mouseScrollablePager
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

enum class Page { Currently, Today, Weekly }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState{ Page.entries.size }
    var searchTextField by rememberSaveable { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    PlaceholderTextField(
                        value = searchTextField,
                        onValueChange = { searchTextField = it },
                        placeholder = "Search location...",
                        icon = Icons.Default.Search,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF5A5B6F),
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            TabRow(selectedTabIndex = pagerState.currentPage, modifier = Modifier) {
                for (index in 0 until pagerState.pageCount) {
                    Tab(selected = index == pagerState.currentPage, modifier = Modifier.heightIn(min = 48.dp), onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }) {
                        Text(text = Page.entries[index].name)
                    }
                }
            }
        }
    ) { innerPadding ->
        HorizontalPager(state = pagerState, modifier = Modifier.mouseScrollablePager(pagerState, scope).padding(innerPadding).fillMaxSize()) { page ->
            when (Page.entries[page]) {
                Page.Currently -> {
                    Text(Page.entries[page].name + " content \uD83D\uDC4B", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                }
                Page.Today -> {
                    Text(Page.entries[page].name + " content \uD83D\uDC4B", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                }
                Page.Weekly -> {
                    Text(Page.entries[page].name + " content \uD83D\uDC4B", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}
