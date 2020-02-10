package com.suraj.greenlightplanetandroidassignment.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Country(
    @SerializedName("country")
    @Expose
    var country: String,
    @SerializedName("territory")
    @Expose
    var territory: String
) : Serializable