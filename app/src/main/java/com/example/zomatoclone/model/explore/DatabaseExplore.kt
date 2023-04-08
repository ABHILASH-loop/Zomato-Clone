package com.example.zomatoclone.model.explore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

object DatabaseExplore {
    private const val TAG = "ExploreResponse"
    fun getExploreItems(): MutableLiveData<List<ExploreResponse>>{

        val responseLiveData = MutableLiveData<List<ExploreResponse>>()

        val database = FirebaseDatabase.getInstance().reference.child("Explore")

        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                val childDataList = mutableListOf<ExploreResponse>()
                for (childSnapShot in snapshot.children){
                    val response = childSnapShot.getValue(ExploreResponse::class.java)
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