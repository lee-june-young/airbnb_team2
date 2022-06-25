package com.example.airbnb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.airbnb.databinding.FragmentPhotoBinding

class PhotoFragment(val imgRes: Int) : Fragment() {

    lateinit var binding: FragmentPhotoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotoBinding.inflate(inflater, container, false)
        binding.bannerImageIv.setImageResource(imgRes)

        return binding.root
    }

}