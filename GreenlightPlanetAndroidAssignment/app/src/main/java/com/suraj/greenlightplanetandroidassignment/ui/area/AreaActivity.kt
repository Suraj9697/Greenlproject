package com.suraj.greenlightplanetandroidassignment.ui.area

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.suraj.greenlightplanetandroidassignment.R
import com.suraj.greenlightplanetandroidassignment.data.model.Area
import com.suraj.greenlightplanetandroidassignment.data.model.Region
import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData
import com.suraj.greenlightplanetandroidassignment.ui.employee.EmployeeActivity
import kotlinx.android.synthetic.main.activity_area.*

class AreaActivity : AppCompatActivity(), AreaContract.View {

    private lateinit var responseData: ResponseData
    private lateinit var selectedRegion: Region

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area)

        supportActionBar?.title = Html.fromHtml("<font color='#FDCF0B'>Metrics</font>")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val upArrow = ContextCompat.getDrawable(this, R.drawable.ic_back_arrow)
        upArrow?.setColorFilter(getColor(R.color.app_yellow), PorterDuff.Mode.SRC_ATOP)
        supportActionBar?.setHomeAsUpIndicator(upArrow)

        selectedRegion = intent.getSerializableExtra("selectedRegion") as Region
        responseData = intent.getSerializableExtra("responseData") as ResponseData

        AreaPresenter(this).start(selectedRegion, responseData)
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

    override fun setAreaRecyclerView(areaList: List<Area>) {
        areaRecyclerView.layoutManager = LinearLayoutManager(this)
        areaRecyclerView.adapter = AreaAdapter(this, areaList) {
            val intent = Intent(this, EmployeeActivity::class.java)
            intent.putExtra("selectedArea", it)
            intent.putExtra("responseData", responseData)
            startActivity(intent)
        }
    }
}
