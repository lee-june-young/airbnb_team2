package com.example.airbnb

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PhotoVPAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    private val fragmentlist: ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int = fragmentlist.size
    /*override fun getItemCount(): Int = Int.MAX_VALUE //무한스크롤위해 시도함 - 실패 */

    override fun createFragment(position: Int): Fragment = fragmentlist[position]

    fun addFragment(fragment: Fragment){
        fragmentlist.add(fragment)
        notifyItemInserted(fragmentlist.size-1)
    }
}