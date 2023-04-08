package com.example.zomatoclone.model.recommendation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object DatabaseRecommendations {
    private const val TAG = "RecommendationResponse"

    fun getRecommendationResponse(): MutableLiveData<List<RecommendedResponse>> {

        // RESPONSE to be returned: format->[RecommendedResponse]
        val responseLiveData = MutableLiveData<List<RecommendedResponse>>()

        // DATABASE REFERENCE ["Recommendations"]
        val database = Firebase.database.reference.child("Recommendations")

        // EVENT LISTENER
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                // TEMP VARIABLE TO STORE
                val childDataList = mutableListOf<RecommendedResponse>()

                // GETTING RESPONSE [Child nodes of Recommendations]
                for (childSnapshot in snapshot.children) {
                    val response = childSnapshot.getValue(RecommendedResponse::class.java)
                    response?.let {
                        childDataList.add(it)
                    }
                }
                responseLiveData.postValue(childDataList)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "loadPost:onCancelled", error.toException())
            }
        })
        return responseLiveData
    }
}
