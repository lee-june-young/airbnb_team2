package com.example.airbnb.data.response

import com.google.gson.annotations.SerializedName

data class IslandResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: IslandResult
)

data class IslandResult(
    @SerializedName("roomLocation") val place: String,
    @SerializedName("roomDistance") val distance: String,
    @SerializedName("roomDate") val date: String,
    @SerializedName("roomEndDate") val endDate: String,
    @SerializedName("cost") val price: Int,
    @SerializedName("roomRating") val rating: Double,
    @SerializedName("roomLike") val roomLike: Int
)

data class IslandResponse2(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val resultImg: ArrayList<IslandResultImg>
)

data class IslandResultImg(
    @SerializedName("roomImgUrl") val imgs: String
)
