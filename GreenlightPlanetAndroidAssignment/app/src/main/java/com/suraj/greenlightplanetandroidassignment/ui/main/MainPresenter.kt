package com.suraj.greenlightplanetandroidassignment.ui.main

import com.suraj.greenlightplanetandroidassignment.data.model.ServiceResponse
import com.suraj.greenlightplanetandroidassignment.data.source.DataRepository
import com.suraj.greenlightplanetandroidassignment.data.source.DataSource

class MainPresenter(var view: MainContract.View) : MainContract.Presenter {

    override fun start() {
        view.showProgressDialog()
        DataRepository.getData(object : DataSource.Callback {
            override fun onResponseReceived(response: ServiceResponse) {
                view.dismissProgressDialog()
                val responseData = response.responseData
                view.navigateToCountryScreen(responseData)
            }

            override fun onError(errorMsg: String) {
                view.dismissProgressDialog()
                view.showToast(errorMsg)
            }

        })
    }

}