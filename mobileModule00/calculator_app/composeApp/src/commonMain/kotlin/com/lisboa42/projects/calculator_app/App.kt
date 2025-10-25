package com.lisboa42.projects.calculator_app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lisboa42.projects.calculator_app.calculator.calculateExpression
import com.lisboa42.projects.calculator_app.common.Log
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    var expression by remember { mutableStateOf("0") }
    var result by remember { mutableStateOf("0") }
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF25414a))
        ) {
            TopAppBar(
                title = {
                    Box(Modifier.fillMaxWidth(), Alignment.Center) {
                        Text("Calculator", color = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0XFF528ba3),
                ),
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(Modifier.fillMaxWidth().fillMaxHeight(0.45f).padding(8.dp), horizontalAlignment = Alignment.End) {
                Text(expression, color = Color(0XFF528ba3), fontSize = 24.sp)
                Text(result, color = Color(0XFF528ba3), fontSize = 24.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Column(Modifier.fillMaxSize().background(Color(0XFF528ba3))) {
                val buttons = listOf(
                    listOf("7", "8", "9", "C", "AC"),
                    listOf("4", "5", "6", "+", "-"),
                    listOf("1", "2", "3", "*", "/"),
                    listOf("0", ".", "00", "=", ""),
                )

                buttons.forEachIndexed { rowIndex, row ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        row.forEachIndexed { buttonIndex, button ->
                            Text(
                                text = button,
                                modifier = Modifier.clip(RoundedCornerShape(12.dp)).clickable(enabled = button.isNotEmpty()) {
                                    Log.i("I/Kotlin", "Button pressed :$button")
                                    if (button == "=") {
                                        result = calculateExpression(expression)
                                    } else if (button == "C") {
                                        expression = expression.dropLast(1)
                                        if (expression == "")
                                            expression = "0"
                                    } else if (button == "AC") {
                                        expression = "0"
                                        result = "0"
                                    } else {
                                        if (expression != "0")
                                            expression += button
                                        else
                                            expression = button
                                    }
                                }.weight(1f),
                                textAlign = TextAlign.Center,
                                color =
                                    if (buttonIndex < buttons.size - 1)
                                        Color(0xFF25414a)
                                    else
                                        if (rowIndex == 0)
                                            (Color.Red.copy(alpha = 0.5F))
                                        else
                                            Color.White
                            )
                        }
                    }
                }
                BottomAppBar(modifier = Modifier.height(24.dp), containerColor = Color.Transparent) {}
            }
        }
    }
}
