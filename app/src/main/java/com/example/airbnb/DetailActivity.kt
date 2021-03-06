package com.example.airbnb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.airbnb.data.response.DetailFacilityResponse
import com.example.airbnb.data.response.DetailHouseInfoResponse
import com.example.airbnb.data.service.DetailService
import com.example.airbnb.data.view.DetailFacilityView
import com.example.airbnb.data.view.DetailView
import com.example.airbnb.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(), DetailFacilityView, DetailView {

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

        //인디케이터 작업
        //전체 배너 몇개인지 변경
        binding.textViewTotalBanner.text = photoAdapter.itemCount.toString() //??왜 getItemCount안 불러와지고 itemCount야
        binding.detailPhotoVp.apply {
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.textViewCurrentBanner.text = "${position+1}"
                }
            })
        }

    }

    override fun onStart() {
        super.onStart()
        val detailService = DetailService()
        detailService.setDetailView(this) //필수정보 setview
        detailService.setDetailFacilityView(this) //편의시설 setview
        detailService.sender(1)
        detailService.sender2(1)
    }

    private fun initRecyclerview(iA:ArrayList<Int>) { //호텔편의시설 recyclerview
        //원래 FLO에서는 context 자리에 걍 context 넣던데 왜 안돼?
        binding.detailFacilitiesRv.layoutManager = LinearLayoutManager(this@DetailActivity,LinearLayoutManager.VERTICAL,false)
        val facilityRVAdapter = DetailFacilitiesRVAdapter()
        binding.detailFacilitiesRv.adapter = facilityRVAdapter
        facilityRVAdapter.addFacilities(iA)

    }

    override fun onDetailFacilityLoading() {
        Log.d("success","로딩")
    }

    override fun onDetailFacilitySuccess(result: ArrayList<DetailFacilityResponse>) {
        //불린
        val dfr : DetailFacilityResponse = result[0]
        val iArray = ArrayList<Int>()
        iArray.add(dfr.wifi)
        iArray.add(dfr.pool)
        iArray.add(dfr.bath)
        iArray.add(dfr.tv)
        iArray.add(dfr.kitchen)

        initRecyclerview(iArray)

        Log.d("success",result.toString())
    }

    override fun onDetailFacilityFailure(code: Int) {
        //
    }

    override fun onDetailLoading() {
        Log.d("success1","로딩")
    }

    override fun onDetailSuccess(result: ArrayList<DetailHouseInfoResponse>) {
        val essential : DetailHouseInfoResponse = result[0]
        binding.detailTitleTv.text="      " + essential.roomName
        binding.detailLocationTv.text=essential.roomLocation
        binding.detailHostTv.text = essential.hostName
        binding.detailHouseExplainTv.text =essential.content
        binding.detailRoomDetailTv.text = "최대 인원 " + essential.maxGuestNum.toString() + "명, 침실 1개, 침대 1개, 욕실 1개"
    }

    override fun onDetailFailure(code: Int) {
       //
    }

}