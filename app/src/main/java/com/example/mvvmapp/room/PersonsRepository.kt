package com.example.mvvmapp.room

import androidx.lifecycle.LiveData
import com.example.mvvmapp.room.Persons
import com.example.mvvmapp.room.PersonsDao

class PersonsRepository(private var personsDao: PersonsDao) {
    val readAllData: LiveData<List<Persons>> = personsDao.readAllData()

    suspend fun addPerson(persons: Persons){
        personsDao.insert(persons)
    }
    suspend fun removeAllPersons(){
        personsDao.removeAllPersons()
    }
    suspend fun delete(persons: Persons){
        personsDao.delete(persons)
    }
}