package com.example.domain.repository

import com.example.domain.model.EmployeeModel

interface EmployeeRepository {
//    suspend fun getEmployees(): List<EmployeeModel>
    suspend fun insertAll(employees: List<EmployeeModel>)
}