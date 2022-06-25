package com.example.airbnb.data.service

import android.util.Log
import com.example.airbnb.ApplicationClass.Companion.retrofit
import com.example.airbnb.RetrofitInterface
import com.example.airbnb.data.response.DetailFacilityResponse
import com.example.airbnb.data.response.DetailResponse
import com.example.airbnb.data.view.DetailFacilityView
import retrofit2.*

class DetailService {
    private lateinit var detailFacilityView: DetailFacilityView

    private val DetailService = retrofit.create(RetrofitInterface::class.java)

    fun setDetailFacilityView(detailFacilityView: DetailFacilityView){
        this.detailFacilityView = detailFacilityView
    }

    fun sender(roomIdx:Int){
        detailFacilityView.onDetailFacilityLoading()

        DetailService.getFacility(roomIdx).enqueue(object:
        Callback<DetailResponse>{
            override fun onResponse(
                call: Call<DetailResponse>,
                response: Response<DetailResponse>
            ) {
                val resp = response.body()!!
                Log.d("success",response.toString())

                when(resp.code){
                    1000->detailFacilityView.onDetailFacilitySuccess(resp.result)
                    else->detailFacilityView.onDetailFacilityFailure(resp.code)
                }
            }

            //통신자체가 안되면
            override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                Log.d("success",t.toString())
            }

        }
        )
    }
}