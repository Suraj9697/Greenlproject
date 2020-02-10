package com.suraj.greenlightplanetandroidassignment.ui.main

import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData

interface MainContract {

    interface Presenter {
        fun start()
    }

    interface View {
        fun showToast(errorMsg: String)
        fun navigateToCountryScreen(responseData: ResponseData)
        fun showProgressDialog()
        fun dismissProgressDialog()
    }
}