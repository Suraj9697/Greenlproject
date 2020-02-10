package com.suraj.greenlightplanetandroidassignment.ui.main

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.suraj.greenlightplanetandroidassignment.R
import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData
import com.suraj.greenlightplanetandroidassignment.ui.country.CountryActivity

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var startButton: ImageView
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.startIcon)
        startButton.setOnClickListener {
            MainPresenter(this).start()
        }
    }

    override fun showToast(errorMsg: String) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToCountryScreen(responseData: ResponseData) {
        val intent = Intent(this, CountryActivity::class.java)
        intent.putExtra("responseData", responseData)
        startActivity(intent)
    }

    override fun showProgressDialog() {
        progressDialog = ProgressDialog.show(this, "Loading...", "Please Wait", true, false)
    }

    override fun dismissProgressDialog() {
        progressDialog.dismiss()
    }
}
