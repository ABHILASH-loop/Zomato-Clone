package com.example.zomatoclone.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.zomatoclone.R
import com.example.zomatoclone.ui.header.Profile
import com.example.zomatoclone.ui.theme.GreenPrimary

@Composable
fun WalletScreen() {
    Surface(Modifier.fillMaxSize()) {
        ConstraintLayout(walletScreenConstraint(), modifier = Modifier.fillMaxWidth()) {
            Box(Modifier.layoutId("profile")) {
                Profile()
            }
            Image(
                painter = painterResource(id = R.drawable.wallet_image),
                contentDescription = "walletImage",
                modifier = Modifier
                    .layoutId("walletImage")
                    .size(256.dp)
            )
            Column(
                modifier = Modifier.layoutId("walletInfo"),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Zomato Wallet",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Seamless one-click checkout for all payments in Zomato",
                    fontSize = 12.sp,
                    color = Color.DarkGray
                )
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .layoutId("activateButton")
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = GreenPrimary,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Activate Wallet", modifier = Modifier.padding(vertical = 4.dp))
            }
            Divider(
                color = Color.LightGray,
                thickness = 6.dp,
                modifier = Modifier.layoutId("divider1")
            )

            Box(
                Modifier
                    .layoutId("infoCard1")
                    .padding(24.dp)
            ) {
                WalletInfoCard(
                    icon = R.drawable.lighting,
                    title = "One-click Checkout",
                    body = "No need to wait for OTPs - payments gets processed instantly"
                )
            }

            Divider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier
                    .layoutId("divider2")
                    .padding(horizontal = 30.dp)
            )

            Box(
                Modifier
                    .layoutId("infoCard2")
                    .padding(24.dp)
            ) {
                WalletInfoCard(
                    icon = R.drawable.secure,
                    title = "Safe and secure",
                    body = "Stay protected with bank-grade security while making payments"
                )
            }

        }
    }
}

@Composable
fun WalletInfoCard(
    icon: Int,
    title: String,
    body: String
) {
    ConstraintLayout(walletScreenConstraint()) {
        Surface(
            shape = CircleShape,
            color = Color(0xFF708090).copy(0.075f),
            border = BorderStroke(1.dp, color = Color(0xFF708090).copy(0.1f)),
            modifier = Modifier
                .layoutId("infoCardIcon")
                .size(62.dp)
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "",
                Modifier
                    .size(54.dp)
                    .padding(14.dp)
            )
        }
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.layoutId("infoCardTitle")
        )
        Text(
            text = body,
            modifier = Modifier.layoutId("infoCardBody"),
            maxLines = 2,
            color = Color.Gray,
            overflow = TextOverflow.Visible
        )
    }
}

@Composable
fun walletScreenConstraint(): ConstraintSet {
    return ConstraintSet {
        val profile = createRefFor("profile")
        val walletImage = createRefFor("walletImage")
        val walletInfo = createRefFor("walletInfo")
        val activateButton = createRefFor("activateButton")
        val divider1 = createRefFor("divider1")
        val infoCard1 = createRefFor("infoCard1")
        val divider2 = createRefFor("divider2")
        val infoCard2 = createRefFor("infoCard2")

        val infoCardIcon = createRefFor("infoCardIcon")
        val infoCardTitle = createRefFor("infoCardTitle")
        val infoCardBody = createRefFor("infoCardBody")

        constrain(profile) {
            top.linkTo(parent.top)
        }
        constrain(walletImage) {
            top.linkTo(profile.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(walletInfo) {
            top.linkTo(walletImage.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(activateButton) {
            top.linkTo(walletInfo.bottom, 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(divider1) {
            top.linkTo(activateButton.bottom, 8.dp)
        }

        constrain(infoCard1) {
            top.linkTo(divider1.bottom, 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(divider2) {
            top.linkTo(infoCard1.bottom)
            start.linkTo(parent.start)
        }

        constrain(infoCard2) {
            top.linkTo(divider2.bottom)
        }

        constrain(infoCardIcon) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }

        constrain(infoCardTitle) {
            top.linkTo(infoCardIcon.top)
            start.linkTo(infoCardIcon.end, 16.dp)
        }

        constrain(infoCardBody) {
            top.linkTo(infoCardTitle.bottom)
            bottom.linkTo(infoCardIcon.bottom)
            start.linkTo(infoCardTitle.start)
            end.linkTo(parent.end)
            width = Dimension.preferredWrapContent
        }

    }
}


@Composable
@Preview(showBackground = true)
fun WalletPreview() {
    WalletScreen()
}


