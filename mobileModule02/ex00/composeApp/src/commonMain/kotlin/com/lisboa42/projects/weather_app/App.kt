package com.lisboa42.projects.weather_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.CalendarViewDay
import androidx.compose.material.icons.filled.CalendarViewMonth
import androidx.compose.material.icons.filled.CalendarViewWeek
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.icons.filled.Weekend
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var iconField by rememberSaveable { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    PlaceholderTextField(
                        value = searchTextField,
                        onValueChange = {
                            searchTextField = it
                            iconField = ""
                        },
                        placeholder = "Search location...",
                        icon = Icons.Default.Search,
                        onIconClick = {
                            searchTextField = ""
                            iconField = "Geolocation"
                        }
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
                for (page in 0 until pagerState.pageCount) {
                    Tab(selected = page == pagerState.currentPage, modifier = Modifier.heightIn(min = 48.dp), onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(page)
                        }
                    }) {
                        val icon = when (Page.entries[page]) {
                            Page.Currently -> Icons.Filled.CalendarViewDay
                            Page.Today -> Icons.Filled.CalendarToday
                            Page.Weekly -> Icons.Filled.CalendarMonth
                        }
                        Icon(imageVector = icon, contentDescription = null)
                        Text(text = Page.entries[page].name)
                    }
                }
            }
        }
    ) { innerPadding ->
        HorizontalPager(state = pagerState, modifier = Modifier.mouseScrollablePager(pagerState, scope).padding(innerPadding).fillMaxSize()) { page ->
            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                when (Page.entries[page]) {
                    Page.Currently -> {
                        Text(Page.entries[page].name, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), fontSize = 28.sp, fontWeight = FontWeight.Bold)
                        Text(searchTextField + iconField, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), fontSize = 28.sp, fontWeight = FontWeight.Bold)

                    }
                    Page.Today -> {
                        Text(Page.entries[page].name, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), fontSize = 28.sp, fontWeight = FontWeight.Bold)
                        Text(searchTextField + iconField, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), fontSize = 28.sp, fontWeight = FontWeight.Bold)
                    }
                    Page.Weekly -> {
                        Text(Page.entries[page].name, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), fontSize = 28.sp, fontWeight = FontWeight.Bold)
                        Text(searchTextField + iconField, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), fontSize = 28.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
