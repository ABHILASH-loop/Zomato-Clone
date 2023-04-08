package com.example.zomatoclone.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.zomatoclone.screens.mainScreen.MainScreenViewModel
import com.example.zomatoclone.ui.body.Body
import com.example.zomatoclone.ui.bottomSheets.filterBottomSheet.FilterSheetMapping
import com.example.zomatoclone.ui.header.HeaderWrapper
import com.example.zomatoclone.ui.header.Profile

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun DeliveryScreen(
    bottomSheetState: ModalBottomSheetState,
    bottomSheetContent: MutableState<FilterSheetMapping>,
    mainNavHostController: NavHostController
) {
    val viewModel:MainScreenViewModel = viewModel()
    LazyColumn(
        Modifier.fillMaxSize()
    ) {
        item {
            Profile()
        }
        stickyHeader {
            HeaderWrapper(bottomSheetState, bottomSheetContent, mainNavHostController)
        }
        item {
            Body()
        }
    }
}