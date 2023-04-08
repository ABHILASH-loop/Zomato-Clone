package com.example.zomatoclone.model.explore

data class ExploreResponse(
    val image: String,
    val text: String,
    val title: String
){
    constructor(): this(
        "not received",
        "not received",
        "not received",
    )
}