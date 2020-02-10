package com.suraj.greenlightplanetandroidassignment.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ServiceResponse(
    @SerializedName("ResponseStatus")
    @Expose
    var responseStatus: Int,
    @SerializedName("ResponseData")
    @Expose
    var responseData: ResponseData,
    @SerializedName("Success")
    @Expose
    var success: Boolean
) : Serializable