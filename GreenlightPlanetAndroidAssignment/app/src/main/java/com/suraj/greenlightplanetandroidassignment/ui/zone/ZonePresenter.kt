package com.suraj.greenlightplanetandroidassignment.ui.zone

import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData

class ZonePresenter(var view: ZoneContract.View) : ZoneContract.Presenter {

    override fun start(responseData: ResponseData) {
        view.setHeadingText("${responseData.country[0].country} Performance")
        view.setZoneRecyclerView(responseData.zone)
    }

}