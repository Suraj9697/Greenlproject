package com.suraj.greenlightplanetandroidassignment.ui.employee

import android.content.Context
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.suraj.greenlightplanetandroidassignment.R
import com.suraj.greenlightplanetandroidassignment.data.model.Area
import com.suraj.greenlightplanetandroidassignment.data.model.Employee
import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData
import kotlinx.android.synthetic.main.activity_area.headerText
import kotlinx.android.synthetic.main.activity_employee.*


class EmployeeActivity : AppCompatActivity(), EmployeeContract.View {

    private lateinit var responseData: ResponseData
    private lateinit var selectedArea: Area
    private lateinit var presenter: EmployeePresenter
    private lateinit var adapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)

        supportActionBar?.title = Html.fromHtml("<font color='#FDCF0B'>Metrics</font>")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val upArrow = ContextCompat.getDrawable(this, R.drawable.ic_back_arrow)
        upArrow?.setColorFilter(getColor(R.color.app_yellow), PorterDuff.Mode.SRC_ATOP)
        supportActionBar?.setHomeAsUpIndicator(upArrow)

        selectedArea = intent.getSerializableExtra("selectedArea") as Area
        responseData = intent.getSerializableExtra("responseData") as ResponseData

        employeeSearchEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                employeeSearchEditText.clearFocus()
                val inputMethodManager: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(employeeSearchEditText.windowToken, 0)

                presenter.searchEmployee(employeeSearchEditText.text.toString())
            }
            true
        }

        presenter = EmployeePresenter(this)
        presenter.start(selectedArea, responseData)
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

    override fun setAreaRecyclerView(employeeList: List<Employee>) {
        employeeRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = EmployeeAdapter(this, employeeList)
        employeeRecyclerView.adapter = adapter
    }

    override fun updateRecyclerView(filteredList: List<Employee>) {
        adapter.employeeList = filteredList
        adapter.notifyDataSetChanged()
    }
}
