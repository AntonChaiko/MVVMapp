package com.example.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.domain.model.EmployeeModel

@Dao
interface EmployeeDao {
    @Query("select * from databaseemployee")
    fun getEmployees(): LiveData<List<DatabaseEmployee>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(employees: List<DatabaseEmployee>)
}