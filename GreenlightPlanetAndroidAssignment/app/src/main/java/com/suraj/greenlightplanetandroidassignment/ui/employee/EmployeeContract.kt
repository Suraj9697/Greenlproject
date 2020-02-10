package com.suraj.greenlightplanetandroidassignment.ui.employee

import com.suraj.greenlightplanetandroidassignment.data.model.Area
import com.suraj.greenlightplanetandroidassignment.data.model.Employee
import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData

interface EmployeeContract {

    interface Presenter {
        fun start(selectedArea: Area, responseData: ResponseData)
        fun searchEmployee(searchString: String)
    }

    interface View {
        fun setHeadingText(text: String)
        fun setAreaRecyclerView(employeeList: List<Employee>)
        fun updateRecyclerView(filteredList: List<Employee>)
    }
}