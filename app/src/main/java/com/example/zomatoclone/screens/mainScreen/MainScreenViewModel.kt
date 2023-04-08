package com.example.zomatoclone.screens.mainScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.zomatoclone.ui.bottomSheets.filterBottomSheet.FilterSheetMapping
import com.example.zomatoclone.ui.theme.GreenPrimary

class MainScreenViewModel: ViewModel(){
    private val cuisineFilters = listOf(
        "American", "Bengali", "Caribbean", "Cajun", "Chettinad", "Chinese", "Continental",
        "Fusion", "French", "German", "Greek", "Gujarati", "Hawaiian", "Hyderabadi", "Indian",
        "Indonesian", "Italian", "Japanese", "Kashmiri", "Korean", "Lebanese", "Mediterranean",
        "Malabar", "Mangalorean", "Mexican", "Middle Eastern", "Peruvian", "Pizza", "Portuguese",
        "Punjabi", "Rajasthani", "Russian", "Ramen", "Seafood", "South American", "South Indian",
        "Southern", "Spanish", "Steak", "Sushi", "Tex-Mex", "Thai", "Turkish", "Udupi", "Vegetarian",
        "Vegan", "Vietnamese", "Waffles", "Western", "Yogurt-based", "Zambian"
    )
    private val sortFilters = listOf(
    SortFilterStruct(0, "Relevance"),
    SortFilterStruct(1, "Rating: High to Low"),
    SortFilterStruct(2, "Delivery Time: Low to High"),
    SortFilterStruct(3, "Delivery Time & Relevance"),
    SortFilterStruct(4, "Distance: Low to High"),
    SortFilterStruct(5, "Cost: Low to High"),
    SortFilterStruct(6, "Cost: High to Low")
    )

    private val checkBoxStates = mutableStateListOf<Boolean>()
    val selectedButtonState = mutableStateOf(sortFilters.first().id)

    fun getCheckBoxValues(): SnapshotStateList<Boolean> {
        cuisineFilters.forEach { _ ->
            checkBoxStates.add(false)
        }
        return checkBoxStates
    }

    fun getFilteredList(search: MutableState<String>): List<String>{
        return if (search.value == "") {
            cuisineFilters
        } else {
            val select = ArrayList<String>()
            cuisineFilters.forEach {
                if (it.lowercase().contains(search.value)) {
                    select.add(it)
                }
            }
            select
        }
    }

    @Composable
    fun SortFilters(){
        sortFilters.forEach {
            val isSelected = it.id == selectedButtonState.value
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp)
                    .clickable {
                        selectedButtonState.value = it.id
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = it.text, fontSize = 14.sp, fontWeight = FontWeight.Normal, fontFamily = FontFamily.SansSerif)
                RadioButton(
                    selected = isSelected,
                    onClick = { selectedButtonState.value = it.id },
                    modifier = Modifier.size(36.dp),
                    colors = RadioButtonDefaults.colors(
                        selectedColor = GreenPrimary,
                        unselectedColor = Color.Gray
                    )
                )
            }
        }
    }
}