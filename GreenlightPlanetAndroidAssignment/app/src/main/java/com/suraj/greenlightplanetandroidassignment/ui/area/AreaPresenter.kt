package com.suraj.greenlightplanetandroidassignment.ui.area

import com.suraj.greenlightplanetandroidassignment.data.model.Region
import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData

class AreaPresenter(var view: AreaContract.View) : AreaContract.Presenter {

    override fun start(selectedRegion: Region, responseData: ResponseData) {
        view.setHeadingText("${selectedRegion.region} Performance")
        view.setAreaRecyclerView(responseData.area.filter {
            it.territory.startsWith(selectedRegion.territory)
        })
    }
}