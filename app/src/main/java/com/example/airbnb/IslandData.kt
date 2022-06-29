package com.example.airbnb

data class IslandData(
    var coverImg : ArrayList<String>?,
    val place : String? = "",
    val distance : String? = "",
    val date : String? = "",
    val price : Int? = null
)
