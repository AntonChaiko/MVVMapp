package com.example.data.mapper

import com.example.data.db.DatabaseEmployee
import com.example.domain.model.EmployeeModel

 fun List<EmployeeModel>.asDomainModel(): List<DatabaseEmployee> {
    return map {
        DatabaseEmployee(
            id = it.id,
            name = it.name,
            number = it.number,
            email = it.email,
            role = it.role
        )
    }
}
 fun List<DatabaseEmployee>.asEmployeeModel(): List<EmployeeModel> {
    return map {
        EmployeeModel(
            id = it.id,
            name = it.name,
            number = it.number,
            email = it.email,
            role = it.role
        )
    }
}