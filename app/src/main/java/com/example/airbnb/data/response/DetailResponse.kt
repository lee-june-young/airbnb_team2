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

//상세정보 필수정보
data class DetailResponse2(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : ArrayList<DetailHouseInfoResponse>
)

data class DetailHouseInfoResponse(
    @SerializedName("roomIdx") val roomIdx : Int,
    @SerializedName("roomName") val roomName : String,
    @SerializedName("roomLocation") val roomLocation : String,
    @SerializedName("content") val content : String,
    @SerializedName("maxGuestNum") val maxGuestNum : Int,
    @SerializedName("hostIdx") val hostIdx : Int,
    @SerializedName("hostName") val hostName : String
)