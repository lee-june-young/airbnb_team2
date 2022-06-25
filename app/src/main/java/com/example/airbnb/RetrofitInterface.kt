package com.example.airbnb


import com.example.airbnb.data.response.DetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitInterface {
    //============상세정보 필수정보 출력====//
    @GET("/room/detail/{roomIdx}")
    fun getFacility(
        @Path("roomIdx") roomIdx: Int
    ) : Call<DetailResponse>
}