package com.example.airbnb.data.view

import com.example.airbnb.data.response.IslandResult
import com.example.airbnb.data.response.IslandResultImg

interface IslandView {
    fun onIslandSuccess(result : IslandResult)
    fun onIslandFailure(code : Int)

    fun onIslandSuccess2(resultImg : ArrayList<IslandResultImg>)
    fun onIslandFailure2(code : Int)
}