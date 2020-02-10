package com.suraj.greenlightplanetandroidassignment.util

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtil {

    companion object {
        fun isConnectedToInternet(context: Context): Boolean {
            var isConnected = false
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            if (networkInfo != null) {
                isConnected = networkInfo.isConnected
            }
            return isConnected
        }
    }
}