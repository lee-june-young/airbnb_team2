package com.example.airbnb
import java.io.Serializable

data class IslandData(
    /*var coverImg : ArrayList<String>?,*/
    var coverImg : Int? = null,
    val place : String? = "",
    val distance : String? = "",
    val date : String? = "",
    val price : Int? = null
): Serializable
