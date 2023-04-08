package com.example.zomatoclone.utils

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zomatoclone.ui.theme.GreenPrimary

@Composable
fun Heading_Design(text: String) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth().padding(top = 16.dp, bottom = 16.dp)

    ) {
        Row(
            Modifier
                .fillMaxWidth(0.2f)
                .drawBehind {
                    drawLine(
                        Color.LightGray,
                        start = Offset(0F, size.height / 2),
                        end = Offset(size.width, size.height / 2),
                        strokeWidth = 3F
                    )
                }
                .padding(4.dp)
        ) {}


        Text(
            text = text,
            color = Color(0xFF454545).copy(alpha = 0.6f),
            modifier = Modifier.padding(horizontal = 8.dp),
            fontSize = 14.sp
        )

        Row(
            Modifier
                .fillMaxWidth(0.9f)
                .drawBehind {
                    drawLine(
                        GreenPrimary,
                        start = Offset(0F, size.height / 2),
                        end = Offset(size.width, size.height / 2),
                        strokeWidth = 3F
                    )
                }
                .padding(start = 16.dp)
        ) {}
    }


}


@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    Heading_Design("Recommended for you")
}

@Preview(showBackground = true)
@Composable
fun ContentPreview2() {
    Heading_Design("Explore")
}