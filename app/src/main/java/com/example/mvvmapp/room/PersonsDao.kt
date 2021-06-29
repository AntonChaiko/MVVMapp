package com.example.mvvmapp.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmapp.room.Persons

@Dao
interface PersonsDao {
    @Query("SELECT * FROM persons_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Persons>>

    @Query("SELECT * FROM persons_table WHERE id = :id")
    fun getById(id: Long): Persons?

    @Insert
    fun insert(persons: Persons?)

    @Update
    fun update(persons: Persons?)

    @Delete
    fun delete(persons: Persons?)

    @Query("DELETE FROM persons_table")
    suspend fun removeAllPersons()
}