package com.example.airbnb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.airbnb.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

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
        initRecyclerview()
    }

    private fun initRecyclerview() {
        binding.detailFacilitiesRv.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        val facilityRVAdapter = DetailFacilitiesRVAdapter()
        facilityRVAdapter.addFacilities()

    }

}