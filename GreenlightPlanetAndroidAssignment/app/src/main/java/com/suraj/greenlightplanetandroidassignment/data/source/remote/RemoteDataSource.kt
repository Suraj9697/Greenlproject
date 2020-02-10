package com.suraj.greenlightplanetandroidassignment.data.source.remote

import com.suraj.greenlightplanetandroidassignment.data.api.Api
import com.suraj.greenlightplanetandroidassignment.data.api.ApiClient
import com.suraj.greenlightplanetandroidassignment.data.model.ServiceResponse
import com.suraj.greenlightplanetandroidassignment.data.source.DataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource : DataSource {
    override fun getData(callback: DataSource.Callback) {
        val api = ApiClient.getClient().create(Api::class.java)
        val call = api.getData()
        call.enqueue(object : Callback<ServiceResponse> {
            override fun onFailure(call: Call<ServiceResponse>, t: Throwable) {
                callback.onError("API failed, please try again")
            }

            override fun onResponse(
                call: Call<ServiceResponse>,
                response: Response<ServiceResponse>
            ) {
                if (response.code() == 200) {
                    val serviceResponse: ServiceResponse? = response.body()
                    if (serviceResponse != null && serviceResponse.success && serviceResponse.responseStatus == 200) {
                        callback.onResponseReceived(serviceResponse)
                    } else {
                        callback.onError("API failed, please try again")
                    }
                } else {
                    callback.onError("API failed, please try again")
                }
            }
        })
    }
}