package com.suraj.greenlightplanetandroidassignment.ui.region

import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData
import com.suraj.greenlightplanetandroidassignment.data.model.Zone

class RegionPresenter(var view: RegionContract.View) : RegionContract.Presenter {

    override fun start(selectedZone: Zone, responseData: ResponseData) {
        view.setHeadingText("${selectedZone.zone} Performance")
        view.setRegionRecyclerView(responseData.region.filter {
            it.territory.startsWith(selectedZone.territory)
        })
    }

}