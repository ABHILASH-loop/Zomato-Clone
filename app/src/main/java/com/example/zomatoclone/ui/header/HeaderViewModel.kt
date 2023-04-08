package com.example.zomatoclone.ui.header

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zomatoclone.model.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HeaderViewModel(
    private val repository: Repository = Repository()
) : ViewModel() {
    var address: MutableState<String> =
        mutableStateOf("Groov Apartment, Door no 4, A2 Block, 2nd Floor, Adambakkam")
    var searchPlaceHolder = mutableStateOf("Restaurant name or a dish...")

    fun changeText() {
        val placeHolders = arrayListOf(
            "Search 'Coffee'",
            "Search 'pizza'",
            "Search 'biriyani'",
            "Search 'chai samosa'"
        )
        viewModelScope.launch {
            delay(2000)
            searchPlaceHolder.value = placeHolders.random()
        }
    }
}