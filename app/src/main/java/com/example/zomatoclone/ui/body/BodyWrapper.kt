package com.example.zomatoclone.ui.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zomatoclone.utils.Heading_Design

@Composable
fun Body() {
    val viewModel: BodyViewModel = viewModel()
    Column(
        Modifier
            .background(Color.White)
            .padding(horizontal = 8.dp)
    ) {
        Column(Modifier.fillMaxWidth()) {
            Heading_Design(text = "RECOMMENDED FOR YOU")
            viewModel.RecommendedWrapper()
        }
        Column(Modifier.fillMaxWidth()) {
            Heading_Design(text = "EXPLORE")
            viewModel.ExploreItemsWrapper()
        }
        Column(Modifier.fillMaxWidth()) {
            for (i in 1..100) {
                Text(text = i.toString())
            }
        }
    }
}




