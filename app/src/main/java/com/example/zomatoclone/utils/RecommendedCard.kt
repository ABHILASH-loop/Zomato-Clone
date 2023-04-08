package com.example.zomatoclone.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun RecommendedCard(
    hotelName: String,
    dishOrPlace: String,
    image: String,
    clockImage: String,
    clockColor: Color,
    time: String,
    offer: String
) {
    Card(
        shape = RoundedCornerShape(12),
        modifier = Modifier
            .padding(8.dp)
            .width(198.dp)
            .height(88.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(12.dp),
                clip = true,
            )
    ) {
        ConstraintLayout(
            constraintSet = recommendedCardConstraints()
        ) {

            Box(
                Modifier.layoutId("image")
            ) {
                /*Image(
                    painter = ImagePainter(image),
                    contentDescription = "Gobi",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.height(64.dp).width(72.dp)
                )*/

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "dishImage",
                    contentScale = ContentScale.Crop,
                    colorFilter = if (offer != "")
                        ColorFilter.lighting(Color.Gray, Color.Black)
                    else
                        null,
                    modifier = Modifier
                        .height(96.dp)
                        .width(88.dp)
                )
            }

            Text(
                text = offer,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .layoutId("offer"),
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = hotelName,
                modifier = Modifier.layoutId("hotelName"),
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )


            Text(
                text = dishOrPlace,
                modifier = Modifier.layoutId("dish_or_place"),
                fontSize = 9.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )


            Spacer(modifier = Modifier.height(8.dp))

            /*Image(
                painter = painterResource(id = clockImage),
                "Clock",
                colorFilter = ColorFilter.tint(clockColor),
                // 3CB371
                // ff6471
                // ffb366
                modifier = Modifier
                    .layoutId("clock")
                    .size(12.dp)
            )*/

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(clockImage)
                    .crossfade(true)
                    .build(),
                contentDescription = "dishImage",
                contentScale = ContentScale.FillBounds,
                colorFilter = ColorFilter.tint(clockColor),
                modifier = Modifier
                    .layoutId("clock")
                    .size(14.dp)
            )

            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = time,
                    modifier = Modifier.layoutId("time"),
                    fontSize = 9.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
}

fun recommendedCardConstraints(): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val dishOrPlace = createRefFor("dish_or_place")
        val hotelName = createRefFor("hotelName")
        val clock = createRefFor("clock")
        val time = createRefFor("time")
        val offer = createRefFor("offer")

        constrain(image) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        }

        constrain(offer) {
            start.linkTo(parent.start, 4.dp)
            end.linkTo(image.end)
            bottom.linkTo(parent.bottom, 8.dp)
            width = Dimension.fillToConstraints
        }

        constrain(hotelName) {
            start.linkTo(image.end, 8.dp)
            top.linkTo(parent.top, 8.dp)
            end.linkTo(parent.end, 8.dp)
            width = Dimension.fillToConstraints
        }

        constrain(dishOrPlace) {
            start.linkTo(hotelName.start)
            end.linkTo(parent.end)
            top.linkTo(hotelName.bottom)
            width = Dimension.fillToConstraints
        }

        constrain(clock) {
            start.linkTo(hotelName.start)
            bottom.linkTo(parent.bottom, 8.dp)
        }

        constrain(time) {
            start.linkTo(clock.end, 2.dp)
            bottom.linkTo(clock.bottom)
            top.linkTo(clock.top)
        }
    }
}

@Preview
@Composable
fun RecommendedCardPreview() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        /*RecommendedCard(hotelName = "Snageetha Veg",
            dishOrPlace = "South Indian",
            image = R.drawable.gobi,
            clockImage = R.drawable.clock,
            clockColor = Color(0xFFff6471),
            time = "45-50 min",
            offer = "Flat 100",
        )*/
    }
}