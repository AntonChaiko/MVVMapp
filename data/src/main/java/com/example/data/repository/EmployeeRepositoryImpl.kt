package com.example.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.data.db.EmployeeDatabase
import com.example.data.mapper.asDomainModel
import com.example.data.mapper.asEmployeeModel
import com.example.domain.model.EmployeeModel
import com.example.domain.repository.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class EmployeeRepositoryImpl(database: EmployeeDatabase) : EmployeeRepository {

    private var employeeDay = database.employeeDao()
    val employee: LiveData<List<EmployeeModel>> = Transformations.map(employeeDay.getEmployees()) {
        it.asEmployeeModel()
    }

    override suspend fun insertAll(employees: List<EmployeeModel>) {
        withContext(Dispatchers.IO){
            employeeDay.insertAll(employees.asDomainModel())
        }
    }


}