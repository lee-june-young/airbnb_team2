package com.example.airbnb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.airbnb.databinding.FragmentPhotoBinding

class PhotoFragment(val imgRes: Int) : Fragment() {

    lateinit var binding: FragmentPhotoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotoBinding.inflate(inflater, container, false)
        binding.bannerImageIv.setImageResource(imgRes)
        //나중에 imgUrl이 들어오면 이게 아니라, 아래처럼 glide이용해야함
        /*Glide.with(binding.root).load(imgUrl).into(binding.bannerImageIv) //이미지*/

        return binding.root
    }

}