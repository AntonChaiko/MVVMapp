package com.example.mvvmapp.ui.screens.viewfragment

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.data.db.EmployeeDatabase
import com.example.data.db.getDatabase
import com.example.data.repository.EmployeeRepositoryImpl
import com.example.domain.model.EmployeeModel
import com.example.mvvmapp.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException


class ViewFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = EmployeeRepositoryImpl(getDatabase(application))

    private val list: LiveData<List<EmployeeModel>> = repository.employee

    private var _employee = MutableLiveData<List<EmployeeModel>>()
    val employee: LiveData<List<EmployeeModel>> = _employee

    init {
//        insertAll()
    }

    fun getEmployeeLiveData(): LiveData<List<EmployeeModel>> {
        return list
    }

    fun insertAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAll(setList())
        }
    }
    fun removeAll(){
        viewModelScope.launch {
            repository.nukeAll()
        }
    }

    private fun setList(): List<EmployeeModel> {
        return listOf(
            EmployeeModel(
                0,
                "Anton Chaiko",
                "375333656218",
                "anton@mail.ru",
                "android-developer",
                R.drawable.img_employee_1
            ),
            EmployeeModel(
                1,
                "Olga Redzkina",
                "375291002030",
                "olha@mail.ru",
                "Head HR",
                R.drawable.img_employee_2
            ),
            EmployeeModel(
                2,
                "Oleg Kozel",
                "375291234567",
                "oleg@mail.ru",
                "java developer",
                R.drawable.img_employee_3
            ),
            EmployeeModel(
                3,
                "Kirill Balanovich",
                "375232154769",
                "kirill@mail.ru",
                "C# developer",
                R.drawable.img_employee_4
            ),
            EmployeeModel(
                4,
                "Egor Gorbachev",
                "375293344555",
                "egor@mail.ru",
                "Kotlin-Developer",
                R.drawable.img_employee_5
            ),
            EmployeeModel(
                5,
                "Sergei Bosak",
                "375291002030",
                "sergei@mail.ru",
                "Project-Manager",
                R.drawable.img_employee_6
            ),
        )
    }
}