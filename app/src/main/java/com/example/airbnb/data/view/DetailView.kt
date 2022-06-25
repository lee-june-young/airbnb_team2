package com.example.airbnb.data.view


import com.example.airbnb.data.response.DetailFacilityResponse

interface DetailFacilityView{
    fun onDetailFacilityLoading()
    fun onDetailFacilitySuccess(result: ArrayList<DetailFacilityResponse>)
    fun onDetailFacilityFailure(code:Int)
}