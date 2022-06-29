package com.example.airbnb

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.airbnb.databinding.FragmentSearchBinding
import com.google.android.material.tabs.TabLayoutMediator


class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding

    private val information = arrayListOf("섬", "국립공원", "통나무집", "기상천외한 숙소")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        //연결 : 수정필요
        val albumAdapter = SearchVPAdapter(this)
        binding.menuContentVp.adapter = albumAdapter

        //tablayout - viewpager 연결
        TabLayoutMediator(binding.menuContentTb, binding.menuContentVp){
                tab, position ->
            tab.text = information[position]

        }.attach() //tablayout과 viewpager붙이기 : attach
        //TabLayoutMediator : tablayout-viewpager2와 연결해주는 중재자
        //tablayout이 선택될 때 해당 viewpager의 위치를 동기화, viewpager 스크롤 시 tablayout 스크롤 위치 동기화

        return binding.root
    }




}