package com.example.airbnb

import android.util.Log
import com.example.airbnb.ApplicationClass.Companion.retrofit
import com.example.airbnb.data.response.IslandResponse
import com.example.airbnb.data.response.IslandResponse2
import com.example.airbnb.data.view.IslandView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class IslandService {
    private lateinit var islandview: IslandView

    private val IslandService = retrofit.create(RetrofitInterface::class.java)

    fun setIslandView(islandview: IslandView){
        this.islandview = islandview
    }

    fun sender(roomIdx:Int){

        IslandService.getIsland(roomIdx).enqueue(object: Callback<IslandResponse> {
            //응답이 왔을 때 처리
            override fun onResponse(call: Call<IslandResponse>, response: Response<IslandResponse>) {
                Log.d("sender1", response.toString())

                if(response.isSuccessful()){
                    val resp:IslandResponse = response.body()!!
                    when(resp.code){
                        //API code값 사용
                        1000->islandview.onIslandSuccess(resp.result) //result를 받아서 UI를 구현해야함
                        else->islandview.onIslandFailure(resp.code) //무슨 오류인지 알아야하므로 code가져가기
                    }
                }
            }
            //실패했을 때 처리
            override fun onFailure(call: Call<IslandResponse>, t: Throwable) {

            }

        })
    }

    fun sender2(roomIdx:Int){
        Log.d("lililili", "야호")
        IslandService.getIsland2(roomIdx).enqueue(object: Callback<IslandResponse2> {
            //응답이 왔을 때 처리
            override fun onResponse(call: Call<IslandResponse2>, response: Response<IslandResponse2>) {

                //★문제: response.body()!!부분에서 code가 404면 body가 null로 와서 에러 발생
                //임시방편으로 response.isSuccessful구문 넣어놨는데,
                //결과코드가 200범위일때 참값을 반환한대.. 그럼 1000은 안들어 오는거 아냐?
                //라는 문제 발생

                if(response.isSuccessful()){ // 통신 성공, 원하는 정보도 제대로 받아옴 or 보냄
                    Log.d("nanana", response.toString())
                    val resp:IslandResponse2 = response.body()!!
                    Log.d("lilili", resp.toString())
                    when(resp.code){
                        //API code값 사용
                        1000->islandview.onIslandSuccess2(resp.resultImg) //result를 받아서 UI를 구현해야함
                        else->islandview.onIslandFailure2(resp.code) //무슨 오류인지 알아야하므로 code가져가기
                    }
                }
                else{  // 통신 성공, 그러나 원하는 정보를 받아오거나 보내지 못함

                }

            }
            //실패했을 때 처리
            override fun onFailure(call: Call<IslandResponse2>, t: Throwable) {
                Log.d("fail", t.toString())
            }

        })
    }
}