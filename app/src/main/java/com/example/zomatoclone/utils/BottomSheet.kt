package com.example.zomatoclone.utils

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zomatoclone.screens.mainScreen.MainScreenViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomBottomSheet(
    sheetContent: @Composable () -> Unit,
    activeScreen: @Composable (ModalBottomSheetState) -> Unit
){
    val viewMode: MainScreenViewModel = viewModel()
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetElevation = 4.dp,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetContent = {
            sheetContent()
        },
        scrimColor = Color.Black.copy(0.6f)
    ) {
        activeScreen(bottomSheetState)
    }
}