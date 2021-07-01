package com.example.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DatabaseEmployee(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var name: String,
    var number: String,
    var email: String,
    var role: String
) {

}
