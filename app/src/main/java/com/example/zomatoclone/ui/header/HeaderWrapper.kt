package com.example.zomatoclone.ui.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.zomatoclone.R
import com.example.zomatoclone.navigation.Graph
import com.example.zomatoclone.ui.bottomSheets.filterBottomSheet.FilterSheetMapping
import com.example.zomatoclone.ui.header.filterButton.Filters
import com.example.zomatoclone.ui.theme.ZomatoCloneTheme
import com.example.zomatoclone.utils.SearchBar

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HeaderWrapper(
    bottomSheetState: ModalBottomSheetState,
    bottomSheetContent: MutableState<FilterSheetMapping>,
    mainNavHostController: NavHostController
) {
    val viewModel: HeaderViewModel = viewModel()
    val search = remember{ mutableStateOf("") }
    val placeHolderText: MutableState<String> = viewModel.searchPlaceHolder

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SearchBar(R.drawable.search, placeholder = placeHolderText.value, search){
            //navController.navigate("TestScreen")
            mainNavHostController.navigate(route = Graph.Search)
        }
        Filters(bottomSheetState, bottomSheetContent)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    ZomatoCloneTheme() {
        //HeaderWrapper()
    }
}