package com.example.restapplication.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restapplication.model.UiState
import com.example.restapplication.network.RestApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        getUsers()
    }


    //call retrofit service and update data uiState
    private fun getUsers(){
        viewModelScope.launch {
            val listUsers = RestApi.retrofitService.getUsers()
            _uiState.update {
                it.copy(users = listUsers)
            }
        }
    }

}