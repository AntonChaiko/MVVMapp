package com.example.mvvmapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "persons_table")
data class Persons(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val number: String,
    val email:String
)
