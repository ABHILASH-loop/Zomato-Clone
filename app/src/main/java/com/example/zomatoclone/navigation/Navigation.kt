package com.example.zomatoclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zomatoclone.screens.TestingScreen
import com.example.zomatoclone.screens.mainScreen.MainScreen

object Graph{
    const val Root = "root"
    const val Search = "search"
    const val MainScreen = "main-screen"
}

@Composable
fun NavigationManager() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Graph.MainScreen,
        route = Graph.Root
    ) {

        composable(Graph.MainScreen) {
            MainScreen(mainNavHostController = navController)
        }

        composable(Graph.Search){
            TestingScreen(text = "Search", navController = navController)
        }
    }
}
