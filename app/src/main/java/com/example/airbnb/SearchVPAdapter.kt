package com.example.airbnb

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SearchVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 4 //"섬", "국립공원", "통나무집", "기상천외한 숙소" : 4개의 fragment필요

    override fun createFragment(position: Int): Fragment {
        return when (position) {//when = switch문
            0 -> IslandFragment() //: 섬
            
            //변경필요
            1 -> IslandFragment() //: 국립공원
            2 -> IslandFragment() //: 통나무집
            else -> IslandFragment() //: 기상천외한 숙소
        }
    }
}