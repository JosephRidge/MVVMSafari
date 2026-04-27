package com.jayr.mvvmsafari.ui.screens.home

import androidx.lifecycle.ViewModel
import com.jayr.mvvmsafari.data.models.StudentModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeScreenViewModel:ViewModel() {
    // states- think about this as data
    private val _student = MutableStateFlow<StudentModel>(StudentModel())
    val student = _student.asStateFlow()


    // methods=> CRUD
    fun setStudentDetails(name:String, age:Int, course:String){
        _student.value = StudentModel(name = name, age = age, course = course)
    }
}