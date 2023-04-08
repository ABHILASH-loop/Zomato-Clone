package com.example.zomatoclone.ui.header.filterButton

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zomatoclone.R
import com.example.zomatoclone.screens.mainScreen.MainScreenViewModel
import com.example.zomatoclone.ui.bottomSheets.filterBottomSheet.FilterSheetMapping
import com.example.zomatoclone.utils.FilterButton
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Filters(
    bottomSheetState: ModalBottomSheetState,
    bottomSheetContent: MutableState<FilterSheetMapping>
) {
    Surface(Modifier.fillMaxWidth()) {
        val scope = rememberCoroutineScope()
        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 12.dp)
        ) {
            val filterList = arrayListOf(

                FilterInfo(
                    onClick = {
                        bottomSheetContent.value = FilterSheetMapping.SortBottomSheet
                        scope.launch {
                            bottomSheetState.show()
                        }
                    },
                    text = "Sort",
                    dropDown = true,
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.settings_sliders),
                            contentDescription = "Sort",
                            tint = Color(0xFF2D2D2D),
                            modifier = Modifier
                                .size(16.dp)
                                .padding(end = 4.dp)
                        )
                    }
                ),
                FilterInfo(
                    onClick = { /*TODO*/ },
                    text = "Fast Delivery",
                    dropDown = false,
                    icon = {}
                ),
                FilterInfo(
                    onClick = { /*TODO*/ },
                    text = "Great Offers",
                    dropDown = false,
                    icon = {}
                ),
                FilterInfo(
                    onClick = { /*TODO*/ },
                    text = "Rating 4.0+",
                    dropDown = false,
                    icon = {}
                ),
                FilterInfo(
                    onClick = { /*TODO*/ },
                    text = "New Arrival",
                    dropDown = false,
                    icon = {}
                ),
                FilterInfo(
                    onClick = { /*TODO*/ },
                    text = "Veg",
                    dropDown = false,
                    icon = {}
                ),
                FilterInfo(
                    onClick = {
                        bottomSheetContent.value = FilterSheetMapping.CuisineBottomSheet
                        scope.launch {
                            bottomSheetState.show()
                        }
                    },
                    text = "Cuisine",
                    dropDown = true,
                    icon = {}
                ),
                FilterInfo(
                    onClick = { /*TODO*/ },
                    text = "More",
                    dropDown = true,
                    icon = {}
                )
            )
            items(filterList) { filter ->
                FilterButton(filter)
            }
        }
    }
}