package com.example.zomatoclone.model.recommendation

data class RecommendedResponse(
    val hotelName: String = "",
    val dishOrPlace: String = "",
    var image: String = "",
    var clockImage: String = "",
    val time: String = "",
    val offer: String = ""
){
    constructor(): this("not received",
        "not received",
        "not received",
        "not recieved",
        "not recieved",
        "not recieved",
    )
}
