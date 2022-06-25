package com.example.airbnb.data.response

import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : ArrayList<DetailFacilityResponse>
)

data class DetailFacilityResponse(
    @SerializedName("roomName") val roomName : String,
    @SerializedName("wifi") val wifi : Int,
    @SerializedName("pool") val pool : Int,
    @SerializedName("bath") val bath : Int,
    @SerializedName("tv") val tv : Int,
    @SerializedName("kitchen") val kitchen : Int
)
