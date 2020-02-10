package com.suraj.greenlightplanetandroidassignment.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Region(
    @SerializedName("region")
    @Expose
    var region: String,
    @SerializedName("territory")
    @Expose
    var territory: String
) : Serializable