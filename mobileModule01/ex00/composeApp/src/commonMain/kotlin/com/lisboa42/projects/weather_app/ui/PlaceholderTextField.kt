package com.lisboa42.projects.weather_app.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun PlaceholderTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    textColor: Color = Color.White,
    placeholderColor: Color = Color.Gray,
    icon: ImageVector? = null,
    iconTint: Color? = null,
    modifier: Modifier = Modifier.padding(0.dp),
    textStyle: TextStyle = LocalTextStyle.current
) {
    Row(modifier.fillMaxWidth().padding(end = 18.dp), verticalAlignment = Alignment.CenterVertically) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = "$placeholder Icon",
                tint = iconTint?: Color.Gray,
                modifier = Modifier.size(20.dp)
            )
        }
        Box(modifier = modifier) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = textStyle.copy(color = textColor),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            if (value.isEmpty()) {
                Text(
                    text = placeholder,
                    style = textStyle.copy(color = placeholderColor),
                    modifier = Modifier.fillMaxWidth(0.8f),
                    maxLines = 1,
                )
            }
        }
        Spacer(Modifier.weight(1f))
        VerticalDivider(thickness = 1.dp, color = Color.White, modifier = Modifier.padding(16.dp))
        Icon(
            imageVector = Icons.Default.NearMe,
            contentDescription = "$placeholder Icon",
            tint = iconTint?: Color.White,
            modifier = Modifier.size(20.dp)
        )
    }
}
