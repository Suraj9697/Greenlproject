package com.suraj.greenlightplanetandroidassignment.ui.region

import com.suraj.greenlightplanetandroidassignment.data.model.Region
import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData
import com.suraj.greenlightplanetandroidassignment.data.model.Zone

interface RegionContract {

    interface Presenter {
        fun start(selectedZone: Zone, responseData: ResponseData)
    }

    interface View {
        fun setHeadingText(text: String)
        fun setRegionRecyclerView(regionList: List<Region>)
    }
}