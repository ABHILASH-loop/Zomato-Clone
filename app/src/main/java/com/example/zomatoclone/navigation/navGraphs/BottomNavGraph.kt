package com.example.zomatoclone.navigation.navGraphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.zomatoclone.navigation.Graph
import com.example.zomatoclone.screens.TestingScreen
import com.example.zomatoclone.ui.DeliveryScreen
import com.example.zomatoclone.ui.WalletScreen
import com.example.zomatoclone.ui.bottomBar.BottomBarItems
import com.example.zomatoclone.ui.bottomSheets.filterBottomSheet.FilterSheetMapping

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNavGraph(
    navController: NavHostController,
    it: PaddingValues,
    bottomSheetState: ModalBottomSheetState,
    bottomSheetContent: MutableState<FilterSheetMapping>,
    mainNavHostController: NavHostController
){
    NavHost(navController = navController, startDestination = BottomBarItems.Delivery.route, route = Graph.Root){
        composable(BottomBarItems.Delivery.route){
            DeliveryScreen(bottomSheetState, bottomSheetContent, mainNavHostController)
        }
        composable(BottomBarItems.Dining.route){
            TestingScreen(text = "Dining", navController = navController)
        }

        composable(BottomBarItems.Grocery.route){
            TestingScreen(text = "Grocery", navController = navController)
        }

        composable(BottomBarItems.Wallet.route){
            WalletScreen()
        }
    }
}