package com.suraj.greenlightplanetandroidassignment.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Area(
    @SerializedName("area")
    @Expose
    var area: String,
    @SerializedName("territory")
    @Expose
    var territory: String
) : Serializable