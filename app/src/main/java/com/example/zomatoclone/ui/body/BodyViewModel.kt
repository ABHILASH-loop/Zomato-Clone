package com.example.zomatoclone.ui.body

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.zomatoclone.model.Repository
import com.example.zomatoclone.model.explore.ExploreResponse
import com.example.zomatoclone.model.recommendation.RecommendedResponse
import com.example.zomatoclone.utils.ExploreCard
import com.example.zomatoclone.utils.RecommendedCard
import kotlinx.coroutines.launch
import kotlin.random.Random

class BodyViewModel(
    private val repository: Repository = Repository()
) : ViewModel() {

    private val recommendedDishesResponse: MutableLiveData<List<RecommendedResponse>>
        get() = repository.getRecommendations()

    private val exploreItemsResponse: MutableLiveData<List<ExploreResponse>>
        get() = repository.getExploreItems()

    @Composable
    private fun randomClockColor(time: String): Color {
        val clockColorList = listOf(
            Color(0xFF3CB371),
            Color(0xFFff6471),
            Color(0xFFffb366)
        )
        return if (time.contains("25")) {
            clockColorList[0]
        } else if (time.contains("45")) {
            clockColorList[1]
        } else if (time.contains("15")) {
            clockColorList[0]
        } else {
            clockColorList[2]
        }
    }

    @Composable
    fun RecommendedWrapper() {
        val recommendedDishes by recommendedDishesResponse.observeAsState(emptyList())
        LazyRow {
            items(recommendedDishes.chunked(2)) { dishPair ->
                Column {
                    dishPair.forEach { recommendedDishes ->
                        RecommendedCard(
                            hotelName = recommendedDishes.hotelName,
                            dishOrPlace = recommendedDishes.dishOrPlace,
                            image = recommendedDishes.image,
                            clockImage = recommendedDishes.clockImage,
                            clockColor = randomClockColor(recommendedDishes.time),
                            time = recommendedDishes.time,
                            offer = recommendedDishes.offer
                        )
                    }
                }

            }
        }
    }

    @Composable
    fun ExploreItemsWrapper() {
        val exploreItems by exploreItemsResponse.observeAsState(emptyList())
        LazyRow() {
            items(exploreItems) { items ->
                ExploreCard(
                    imageUrl = items.image,
                    title = items.title,
                    text = items.text,
                    textColor = if (items.title.contains("Offers")) {
                        Color(0xFF38b6ff)
                    } else if (items.title.contains("Legends")) {
                        Color(0xFFd4af37)
                    } else
                        Color.Gray
                )
            }
        }
    }

}
