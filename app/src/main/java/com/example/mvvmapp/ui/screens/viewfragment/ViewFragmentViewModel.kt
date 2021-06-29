package com.example.mvvmapp.ui.screens.viewfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmapp.room.Persons
import com.example.mvvmapp.room.PersonsRepository
import com.example.mvvmapp.ui.base.BaseViewModel

class ViewFragmentViewModel(private val repository: PersonsRepository) : BaseViewModel() {

}