package com.example.airbnb


import com.example.airbnb.data.response.DetailResponse
import com.example.airbnb.data.response.DetailResponse2
import com.example.airbnb.data.response.IslandResponse
import com.example.airbnb.data.response.IslandResponse2
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitInterface {
    //============상세정보 필수정보 출력====//
    @GET("/room/{roomIdx}")
    fun getDetail(
        @Path("roomIdx") roomIdx: Int
    ) : Call<DetailResponse2>

    //============상세정보 편의시설 출력====//
    @GET("/room/detail/{roomIdx}")
    fun getFacility(
        @Path("roomIdx") roomIdx: Int
    ) : Call<DetailResponse>

    //=======Lize파트- island ====//
    @GET("/main/{roomIdx}")
    fun getIsland(
        @Path("roomIdx") roomIdx: Int
    ): Call<IslandResponse> //response -> 나중에 Callback<>에 들어갈 내용

    @GET("/main/images/{roomIdx}")
    fun getIsland2(
        @Path("roomIdx") roomIdx: Int
    ): Call<IslandResponse2> //response -> 나중에 Callback<>에 들어갈 내용



}