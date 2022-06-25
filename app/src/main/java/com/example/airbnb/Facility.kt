package com.example.airbnb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FacilityTable")
data class Facility(
    var content: String = "",
    var coverImg: Int? =null
){
    @PrimaryKey(autoGenerate = true) var id: Int=0
}
