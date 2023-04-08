package com.example.zomatoclone.model

import androidx.lifecycle.MutableLiveData
import com.example.zomatoclone.model.explore.DatabaseExplore
import com.example.zomatoclone.model.explore.ExploreResponse
import com.example.zomatoclone.model.recommendation.DatabaseRecommendations
import com.example.zomatoclone.model.recommendation.RecommendedResponse

class Repository(
    private val databaseRecommendations: DatabaseRecommendations = DatabaseRecommendations,
    private val databaseExplore: DatabaseExplore = DatabaseExplore,

    ) {
    fun getRecommendations(): MutableLiveData<List<RecommendedResponse>> {
        return databaseRecommendations.getRecommendationResponse()
    }

    fun getExploreItems(): MutableLiveData<List<ExploreResponse>> {
        return  databaseExplore.getExploreItems()
    }

}