package com.example.zomatoclone.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavController
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.navigation
//import com.example.zomatoclone.screens.mainScreen.MainScreen
//import com.example.zomatoclone.ui.bottomNavigation.BottomNavItems
//
//
//
//CustomBottomSheet(
//sheetContent = {
//    when (bottomSheetContent.value) {
//        FilterSheetMapping.SortBottomSheet -> SortBottomSheet(viewModel)
//        FilterSheetMapping.CuisineBottomSheet -> CuisineBottomSheet(viewModel)
//    }
//}
//) {
//    MainScreenContent(
//        navController = navController,
//        bottomSheetContent = bottomSheetContent,
//        bottomSheetState = it
//    )
//}