package com.example.airbnb

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.airbnb.databinding.ItemFacilitiesDetailBinding

class DetailFacilitiesRVAdapter() :
    RecyclerView.Adapter<DetailFacilitiesRVAdapter.ViewHolder>() {
    private val facilities =ArrayList<Boolean>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DetailFacilitiesRVAdapter.ViewHolder {
        val binding: ItemFacilitiesDetailBinding = ItemFacilitiesDetailBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailFacilitiesRVAdapter.ViewHolder, position: Int) {
        holder.bind(facilities[position], position)

    }

    override fun getItemCount(): Int = facilities.size

    inner class ViewHolder(val binding: ItemFacilitiesDetailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(facility: Boolean, position: Int) {
            when(position){
                0->{ //wifi여부

                }
                1->{ //수영장 여부

                }
                2->{ //욕조 여부

                }
                3->{ //Tv여부

                }
                4->{ //부엌여부

                }

            }
        }
    }

}