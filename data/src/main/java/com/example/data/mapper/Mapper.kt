package com.example.data.mapper

import com.example.data.db.EmployeeDb
import com.example.domain.model.EmployeeModel

 fun List<EmployeeModel>.asDomainModel(): List<EmployeeDb> {
    return map {
        EmployeeDb(
            id = it.id,
            name = it.name,
            number = it.number,
            email = it.email,
            role = it.role,
            imgId= it.imgId.toLong()
        )
    }
}
 fun List<EmployeeDb>.asEmployeeModel(): List<EmployeeModel> {
    return map {
        EmployeeModel(
            id = it.id,
            name = it.name,
            number = it.number,
            email = it.email,
            role = it.role,
            imgId = it.imgId.toInt()
        )
    }
}