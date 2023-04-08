package com.example.zomatoclone.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.SweepGradient
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@OptIn(ExperimentalTextApi::class)
@Composable
fun ExploreCard(
    imageUrl: String = "https://firebasestorage.googleapis.com/v0/b/zomato-clone-297ff.appspot.com/o/ExploreImages%2Fgourmet.png?alt=media&token=2a731ff0-201b-4409-8bfd-461890467a55",
    text: String = "Gourmet",
    title: String = "Selections",
    textColor: Color = Color.Gray
) {
    Card(
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(8.dp),
                clip = true,
                spotColor = Color.DarkGray
            ),
        shape = RoundedCornerShape(8)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(modifier = Modifier.padding(top=8.dp, start = 16.dp, end=16.dp).size(96.dp)) {

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "")

                /*Image(
                    painter = painterResource(id = R.drawable.gourmet),
                    contentDescription = "",
                )*/
            }
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 12.dp)
            )
            Text(
                text = text,
                color = textColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 12.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExplorePreview() {
    Box() {
        ExploreCard()
    }
}
