package com.suraj.greenlightplanetandroidassignment.ui.zone

import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData
import com.suraj.greenlightplanetandroidassignment.data.model.Zone

interface ZoneContract {

    interface Presenter {
        fun start(responseData: ResponseData)
    }

    interface View {
        fun setHeadingText(text: String)
        fun setZoneRecyclerView(zoneList: List<Zone>)
    }
}