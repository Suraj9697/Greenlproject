package com.suraj.greenlightplanetandroidassignment.ui.employee

import com.suraj.greenlightplanetandroidassignment.data.model.Area
import com.suraj.greenlightplanetandroidassignment.data.model.Employee
import com.suraj.greenlightplanetandroidassignment.data.model.ResponseData

class EmployeePresenter(var view: EmployeeContract.View) : EmployeeContract.Presenter {

    private lateinit var employeeList: List<Employee>

    override fun start(selectedArea: Area, responseData: ResponseData) {
        view.setHeadingText("${selectedArea.area} Performance")
        employeeList = responseData.employee.filter {
            it.territory == selectedArea.territory
        }
        view.setAreaRecyclerView(employeeList)
    }

    override fun searchEmployee(searchString: String) {
        val filteredList = employeeList.filter {
            it.name.contains(searchString, ignoreCase = true)
        }

        view.updateRecyclerView(filteredList)
    }

}
