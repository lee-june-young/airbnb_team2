package com.example.airbnb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.airbnb.data.response.DetailFacilityResponse
import com.example.airbnb.data.service.DetailService
import com.example.airbnb.data.view.DetailFacilityView
import com.example.airbnb.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(), DetailFacilityView {

    lateinit var binding: ActivityDetailBinding
    /*private var facilityDatas = ArrayList<Facility>()*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //배너작업
        val photoAdapter = PhotoVPAdapter(this)
        photoAdapter.addFragment(PhotoFragment(R.drawable.img_detail_viewpager_exp)) //사진 넣기
        photoAdapter.addFragment(PhotoFragment(R.drawable.img_detail_viewpager_exp2))
        photoAdapter.addFragment(PhotoFragment(R.drawable.img_detail_viewpager_exp)) //사진 넣기
        photoAdapter.addFragment(PhotoFragment(R.drawable.img_detail_viewpager_exp2))


        binding.detailPhotoVp.adapter = photoAdapter
        binding.detailPhotoVp.orientation=ViewPager2.ORIENTATION_HORIZONTAL

    }

    override fun onStart() {
        super.onStart()
        val detailService = DetailService()
        detailService.setDetailFacilityView(this) //setview
        detailService.sender(1)

        initRecyclerview()
    }

    private fun initRecyclerview() { //호텔편의시설 recyclerview
        //원래 FLO에서는 context 자리에 걍 context 넣던데 왜 난 안돼?
        binding.detailFacilitiesRv.layoutManager = LinearLayoutManager(this@DetailActivity,LinearLayoutManager.VERTICAL,false)
        val facilityRVAdapter = DetailFacilitiesRVAdapter()
        binding.detailFacilitiesRv.adapter = facilityRVAdapter



    }

    override fun onDetailFacilityLoading() {
        Log.d("success","로딩")
    }

    override fun onDetailFacilitySuccess(result: ArrayList<DetailFacilityResponse>) {
        //불린

        Log.d("success",result.toString())
    }

    override fun onDetailFacilityFailure(code: Int) {
        //
    }

}