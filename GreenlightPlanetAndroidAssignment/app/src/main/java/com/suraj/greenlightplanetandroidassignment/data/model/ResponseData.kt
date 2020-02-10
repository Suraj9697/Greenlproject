package com.suraj.greenlightplanetandroidassignment.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ResponseData(
    @SerializedName("country")
    @Expose
    var country: List<Country>,
    @SerializedName("zone")
    @Expose
    var zone: List<Zone>,
    @SerializedName("region")
    @Expose
    var region: List<Region>,
    @SerializedName("area")
    @Expose
    var area: List<Area>,
    @SerializedName("employee")
    @Expose
    var employee: List<Employee>
) : Serializable