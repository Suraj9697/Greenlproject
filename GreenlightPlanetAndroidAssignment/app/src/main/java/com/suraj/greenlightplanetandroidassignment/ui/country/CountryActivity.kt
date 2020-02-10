package com.suraj.greenlightplanetandroidassignment.ui.country

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.suraj.greenlightplanetandroidassignment.R
import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData
import com.suraj.greenlightplanetandroidassignment.ui.zone.ZoneActivity
import kotlinx.android.synthetic.main.activity_country.*

class CountryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        supportActionBar?.title = Html.fromHtml("<font color='#FDCF0B'>Metrics</font>")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val upArrow = ContextCompat.getDrawable(this, R.drawable.ic_back_arrow)
        upArrow?.setColorFilter(getColor(R.color.app_yellow), PorterDuff.Mode.SRC_ATOP)
        supportActionBar?.setHomeAsUpIndicator(upArrow)

        val responseData: ResponseData = intent.getSerializableExtra("responseData") as ResponseData

        countryButton.setOnClickListener {
            val intent = Intent(this, ZoneActivity::class.java)
            intent.putExtra("responseData", responseData)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
