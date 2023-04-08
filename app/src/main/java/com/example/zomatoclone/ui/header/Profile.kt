package com.example.zomatoclone.ui.header

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.zomatoclone.R
import com.example.zomatoclone.ui.theme.GreenPrimary

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Profile() {
    val viewModel: HeaderViewModel = viewModel()
    val address = viewModel.address.value
    Surface(
        Modifier
            .fillMaxWidth()
            .padding(end=8.dp)
    ) {
        ConstraintLayout(userInfoConstraint(), modifier = Modifier.fillMaxWidth()) {
            Icon(
                painterResource(id = R.drawable.marker),
                contentDescription = "Location Icon",
                tint = GreenPrimary,
                modifier = Modifier
                    .layoutId("locationIcon")
                    .size(20.dp)
            )
            Text(
                text = "Home",
                modifier = Modifier.layoutId("home"),
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .layoutId("more")
                    .size(16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "More Home Options",
                    tint = Color(0xFF2D2D2D),
                    modifier = Modifier.size(12.dp)
                )
            }

            Text(
                text = address,
                modifier = Modifier.layoutId("address"),
                fontSize = 10.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold
            )


            Surface(
                onClick = { /*TODO*/ },
                elevation = 2.dp,
                color = Color.White,
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .layoutId("translate")
                    .size(32.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.translation),
                    contentDescription = "Translator",
                    Modifier
                        .padding(6.dp)
                        .size(12.dp),
                    tint = Color(0xFF2D2D2D)
                )
            }

            Surface(
                onClick = { /*TODO*/ },
                shape = CircleShape,
                color = Color(0xFFE4E5E7),
                modifier = Modifier.layoutId("profile").size(32.dp)
            ) {
                Icon(
                    painterResource(id = R.drawable.user),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(2.dp).padding(top = 4.dp),
                    tint = Color(0xFFAFB2B7)
                )
            }
        }
    }
}

@Composable
fun userInfoConstraint(): ConstraintSet {
    return ConstraintSet {
        val locationIcon = createRefFor("locationIcon")
        val home = createRefFor("home")
        val address = createRefFor("address")
        val more = createRefFor("more")
        val profile = createRefFor("profile")
        val translate = createRefFor("translate")

        constrain(locationIcon) {
            top.linkTo(parent.top, 18.dp)
            start.linkTo(parent.start, 16.dp)
        }

        constrain(home) {
            top.linkTo(parent.top, 14.dp)
            start.linkTo(locationIcon.end, 4.dp)
        }

        constrain(more) {
            top.linkTo(home.top)
            start.linkTo(home.end, 1.dp)
            bottom.linkTo(home.bottom)
        }

        constrain(address) {
            top.linkTo(home.bottom, 4.dp)
            bottom.linkTo(locationIcon.bottom)
            start.linkTo(home.start)
            end.linkTo(translate.start, 16.dp)
            width = Dimension.fillToConstraints
        }

        constrain(profile) {
            top.linkTo(home.top)
            end.linkTo(parent.end, 8.dp)
            bottom.linkTo(address.bottom, 2.dp)
        }

        constrain(translate) {
            top.linkTo(profile.top)
            end.linkTo(profile.start, 8.dp)
            bottom.linkTo(address.bottom)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    //Profile()
}