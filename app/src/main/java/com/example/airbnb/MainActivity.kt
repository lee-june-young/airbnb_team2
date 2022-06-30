package com.example.airbnb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.airbnb.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater) //binding 초기화
        setContentView(binding.root)

        initBottomNavigation()
    }

    //fragment를 전환해 각각의 화면을 보여줌
    private fun initBottomNavigation(){

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, SearchFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener{ item ->
            when (item.itemId) {

                R.id.searchFragment -> { //homeFragment를 눌렀을 때
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SearchFragment()) //homeFragment보여지기
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.wishlistFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, WishlistFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.tripFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, TripFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.messageFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, MessageFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.profileFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, ProfileFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}