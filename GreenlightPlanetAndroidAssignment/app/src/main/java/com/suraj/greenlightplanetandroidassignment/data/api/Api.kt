package com.suraj.greenlightplanetandroidassignment.data.api

import com.suraj.greenlightplanetandroidassignment.data.model.ServiceResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("assignment")
    fun getData(): Call<ServiceResponse>
}