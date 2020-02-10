package com.suraj.greenlightplanetandroidassignment.ui.zone

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.suraj.greenlightplanetandroidassignment.R
import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData
import com.suraj.greenlightplanetandroidassignment.data.model.Zone
import com.suraj.greenlightplanetandroidassignment.ui.region.RegionActivity
import kotlinx.android.synthetic.main.activity_zone.*

class ZoneActivity : AppCompatActivity(), ZoneContract.View {

    private lateinit var responseData: ResponseData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zone)

        supportActionBar?.title = Html.fromHtml("<font color='#FDCF0B'>Metrics</font>")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val upArrow = ContextCompat.getDrawable(this, R.drawable.ic_back_arrow)
        upArrow?.setColorFilter(getColor(R.color.app_yellow), PorterDuff.Mode.SRC_ATOP)
        supportActionBar?.setHomeAsUpIndicator(upArrow)

        responseData = intent.getSerializableExtra("responseData") as ResponseData

        ZonePresenter(this).start(responseData)
    }

    override fun setHeadingText(text: String) {
        headerText.text = text
    }

    override fun setZoneRecyclerView(zoneList: List<Zone>) {
        zoneRecyclerView.layoutManager = LinearLayoutManager(this)
        zoneRecyclerView.adapter = ZoneAdapter(this, zoneList) {
            val intent = Intent(this, RegionActivity::class.java)
            intent.putExtra("selectedZone", it)
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
