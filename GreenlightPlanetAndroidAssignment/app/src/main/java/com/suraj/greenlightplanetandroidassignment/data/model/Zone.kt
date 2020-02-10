package com.suraj.greenlightplanetandroidassignment.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Zone(
    @SerializedName("zone")
    @Expose
    var zone: String,
    @SerializedName("territory")
    @Expose
    var territory: String
) : Serializable