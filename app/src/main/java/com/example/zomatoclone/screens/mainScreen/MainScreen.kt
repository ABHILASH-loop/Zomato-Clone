package com.example.zomatoclone.screens.mainScreen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.zomatoclone.navigation.navGraphs.BottomNavGraph
import com.example.zomatoclone.ui.bottomBar.BottomBar
import com.example.zomatoclone.ui.bottomSheets.filterBottomSheet.CuisineBottomSheet
import com.example.zomatoclone.ui.bottomSheets.filterBottomSheet.FilterSheetMapping
import com.example.zomatoclone.ui.bottomSheets.filterBottomSheet.SortBottomSheet
import com.example.zomatoclone.utils.CustomBottomSheet


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    mainNavHostController: NavHostController
) {
    val viewModel: MainScreenViewModel = viewModel()
    val bottomSheetContent = remember{ mutableStateOf(FilterSheetMapping.SortBottomSheet) }
        CustomBottomSheet(
        sheetContent = {
            when (bottomSheetContent.value) {
                FilterSheetMapping.SortBottomSheet -> SortBottomSheet(viewModel)
                FilterSheetMapping.CuisineBottomSheet -> CuisineBottomSheet(viewModel)
            }
        }
    ) {bottomSheetState ->
        Scaffold(bottomBar = { BottomBar(navController = navController) }) {
            BottomNavGraph(
                navController,
                it,
                bottomSheetState,
                bottomSheetContent,
                mainNavHostController,
            )
        }
    }
}


