package com.jayr.mvvmsafari.ui.screens.hobby

import androidx.lifecycle.ViewModel
import com.jayr.mvvmsafari.data.models.HobbyModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HobbyViewModel : ViewModel() {

    //    states
    private val _hobby = MutableStateFlow(HobbyModel())
    val hobby = _hobby.asStateFlow()

    //    methods => CRUD
    fun createHobby(name: String, description: String) {
        _hobby.value = HobbyModel(name= name, description = description)
    }
}