package com.example.zomatoclone.ui.header.filterButton

import androidx.compose.runtime.Composable

data class FilterInfo(
    val onClick: () -> Unit,
    val text: String,
    val dropDown: Boolean,
    val icon: @Composable() () -> Unit
)
