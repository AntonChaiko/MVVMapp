package com.example.mvvmapp.ui.screens.viewfragment

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.data.db.EmployeeDatabase
import com.example.data.db.getDatabase
import com.example.data.repository.EmployeeRepositoryImpl
import com.example.domain.model.EmployeeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException


class ViewFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = EmployeeRepositoryImpl(getDatabase(application))

    val list: LiveData<List<EmployeeModel>> = repository.employee

    private var _employee = MutableLiveData<List<EmployeeModel>>()
    val employee: LiveData<List<EmployeeModel>> = _employee

//    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)
//    val isNetworkErrorShown: LiveData<Boolean>
//        get() = _isNetworkErrorShown


    init {
        Log.d("asd", "init...")
        insertAll()
    }

    fun getEmployeeLiveData(): LiveData<List<EmployeeModel>> {
        return list
    }

    private fun insertAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAll(setList())
        }
    }

    private fun setList(): List<EmployeeModel> {
        return listOf(
            EmployeeModel(0, "vaysa pypkin", "23", "kekW", "4el"),
            EmployeeModel(0, "asdasd pypkin", "asdasd", "1234", "4123")
        )
    }
}