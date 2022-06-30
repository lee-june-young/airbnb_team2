package com.example.airbnb.data.service

import android.util.Log
import com.example.airbnb.ApplicationClass.Companion.retrofit
import com.example.airbnb.RetrofitInterface
import com.example.airbnb.data.response.DetailResponse
import com.example.airbnb.data.response.DetailResponse2
import com.example.airbnb.data.view.DetailFacilityView
import com.example.airbnb.data.view.DetailView
import retrofit2.*

class DetailService {
    private lateinit var detailView: DetailView //필수정보
    private lateinit var detailFacilityView: DetailFacilityView //숙소편의시설정보

    private val DetailService = retrofit.create(RetrofitInterface::class.java)

    fun setDetailFacilityView(detailFacilityView: DetailFacilityView){
        this.detailFacilityView = detailFacilityView
    }

    fun setDetailView(detailView: DetailView){
        this.detailView = detailView
    }

    fun sender(roomIdx:Int){ //필수정보
        detailView.onDetailLoading()


        DetailService.getDetail(roomIdx).enqueue(object:
            Callback<DetailResponse2>{
            override fun onResponse(
                call: Call<DetailResponse2>,
                response: Response<DetailResponse2>
            ) {
                val resp = response.body()!!
                Log.d("success1",response.toString())

                when(resp.code){
                    1000->detailView.onDetailSuccess(resp.result)
                    else->detailView.onDetailFailure(resp.code)
                }
            }

            //통신자체가 안되면
            override fun onFailure(call: Call<DetailResponse2>, t: Throwable) {
                Log.d("success1",t.toString())
            }

        }
        )
    }

    fun sender2(roomIdx:Int){ //편의시설
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