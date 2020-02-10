package com.suraj.greenlightplanetandroidassignment.ui.area

import com.suraj.greenlightplanetandroidassignment.data.model.Area
import com.suraj.greenlightplanetandroidassignment.data.model.Region
import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData

interface AreaContract {

    interface Presenter {
        fun start(selectedRegion: Region, responseData: ResponseData)
    }

    interface View {
        fun setHeadingText(text: String)
        fun setAreaRecyclerView(areaList: List<Area>)
    }
}