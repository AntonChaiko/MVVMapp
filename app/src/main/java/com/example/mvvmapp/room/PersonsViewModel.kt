package com.example.mvvmapp.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PersonsViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<Persons>>
    private val repository: PersonsRepository

    init {
        val personsDao = PersonsDatabase.getDatabase(application).wordsDao()
        repository = PersonsRepository(personsDao!!)
        readAllData = repository.readAllData
    }

    fun addPerson(persons: Persons) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPerson(persons)
        }
    }

    fun removeAllPersons() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeAllPersons()
        }
    }
    fun removeCurrentPerson(persons: Persons) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(persons)
        }
    }
}