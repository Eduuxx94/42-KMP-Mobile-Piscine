package com.lisboa42.projects.weather_app.ui

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.pager.PagerState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun Modifier.mouseScrollablePager(pagerState: PagerState, scope: CoroutineScope): Modifier = pointerInput(Unit) {
    var totalDragX = 0f

    detectDragGestures(
        onDragStart = { totalDragX = 0f },
        onDrag = { change, dragAmount ->
            change.consume()
            totalDragX += dragAmount.x

            scope.launch {
                pagerState.scrollBy(-dragAmount.x)
            }
        },
        onDragEnd = {
            val pageWidth = pagerState.layoutInfo.pageSize
            val targetPage = when {
                totalDragX < -pageWidth -> pagerState.currentPage + 1
                totalDragX > pageWidth -> pagerState.currentPage - 1
                else -> pagerState.currentPage
            }.coerceIn(0, pagerState.pageCount - 1)
            scope.launch {
                pagerState.animateScrollToPage(targetPage)
            }
        }
    )
}