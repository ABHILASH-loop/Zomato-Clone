package com.example.zomatoclone.ui.bottomBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.zomatoclone.R
import com.example.zomatoclone.ui.theme.GreenPrimary

sealed class BottomBarItems(
    val route: String,
    val label: String,
    val icon: Int
) {
    object Delivery : BottomBarItems("home", "Delivery", R.drawable.fast_delivery)
    object Dining : BottomBarItems("dining", "Dining", R.drawable.dining)
    object Grocery : BottomBarItems("grocery", "Grocery", R.drawable.groceries)
    object Wallet : BottomBarItems("wallet", "Wallet", R.drawable.wallet_passes_app)
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarItems.Delivery,
        BottomBarItems.Dining,
        BottomBarItems.Grocery,
        BottomBarItems.Wallet
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Box {
        BottomNavigation(
            backgroundColor = Color.White,
            elevation = 16.dp,
            contentColor = Color.Gray,
            modifier = Modifier.drawBehind {
                // Get the selected item index
                val selectedIndex = screens.indexOfFirst {
                    currentDestination?.hierarchy?.any { hierarchy ->
                        hierarchy.route == it.route
                    } == true
                }
                // Calculate the start and end coordinates for the highlight line
                val itemWidth = size.width / screens.size
                val startX = selectedIndex * itemWidth
                val stopX = (selectedIndex + 1) * itemWidth
                // Draw the highlight line
                drawLine(
                    color = GreenPrimary,
                    start = Offset(startX, 0f),
                    end = Offset(stopX, 0f),
                    strokeWidth = 16f,
                    cap = StrokeCap.Companion.Round
                )
            }
        ) {

            screens.forEach{screen ->
                val isSelected = currentDestination?.hierarchy?.any {
                    currentDestination.route == screen.route
                } == true
                BottomNavigationItem(
                    selected = isSelected,
                    onClick = {
                        navController.navigate(screen.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = screen.icon),
                            contentDescription = "NavItems", modifier = Modifier.size(24.dp),
                            tint = if (isSelected) {
                                GreenPrimary
                            } else {
                                Color.Gray
                            }
                        )
                    },
                    label = {
                        Text(
                            text = screen.label,
                            fontSize = 10.sp,
                            modifier = Modifier.padding(vertical = 20.dp)
                        )
                    }
                )
            }
        }
    }
}
