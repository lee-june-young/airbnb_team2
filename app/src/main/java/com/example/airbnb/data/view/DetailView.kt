package com.example.airbnb.data.view


import com.example.airbnb.data.response.DetailFacilityResponse
import com.example.airbnb.data.response.DetailHouseInfoResponse

interface DetailFacilityView{
    fun onDetailFacilityLoading()
    fun onDetailFacilitySuccess(result: ArrayList<DetailFacilityResponse>)
    fun onDetailFacilityFailure(code:Int)
}

interface DetailView{
    fun onDetailLoading()
    fun onDetailSuccess(result: ArrayList<DetailHouseInfoResponse>)
    fun onDetailFailure(code:Int)
}