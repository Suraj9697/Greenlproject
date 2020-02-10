package com.suraj.greenlightplanetandroidassignment.ui.region

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.suraj.greenlightplanetandroidassignment.R
import com.suraj.greenlightplanetandroidassignment.data.model.Region
import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData
import com.suraj.greenlightplanetandroidassignment.data.model.Zone
import com.suraj.greenlightplanetandroidassignment.ui.area.AreaActivity
import kotlinx.android.synthetic.main.activity_region.*

class RegionActivity : AppCompatActivity(), RegionContract.View {

    private lateinit var responseData: ResponseData
    private lateinit var selectedZone: Zone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_region)

        supportActionBar?.title = Html.fromHtml("<font color='#FDCF0B'>Metrics</font>")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val upArrow = ContextCompat.getDrawable(this, R.drawable.ic_back_arrow)
        upArrow?.setColorFilter(getColor(R.color.app_yellow), PorterDuff.Mode.SRC_ATOP)
        supportActionBar?.setHomeAsUpIndicator(upArrow)

        selectedZone = intent.getSerializableExtra("selectedZone") as Zone
        responseData = intent.getSerializableExtra("responseData") as ResponseData

        RegionPresenter(this).start(selectedZone, responseData)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setHeadingText(text: String) {
        headerText.text = text
    }

    override fun setRegionRecyclerView(regionList: List<Region>) {
        regionRecyclerView.layoutManager = LinearLayoutManager(this)
        regionRecyclerView.adapter = RegionAdapter(this, regionList) {
            val intent = Intent(this, AreaActivity::class.java)
            intent.putExtra("selectedRegion", it)
            intent.putExtra("responseData", responseData)
            startActivity(intent)
        }
    }
}
