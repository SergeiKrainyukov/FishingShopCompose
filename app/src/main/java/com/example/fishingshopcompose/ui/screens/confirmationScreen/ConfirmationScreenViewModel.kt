package com.example.fishingshopcompose.ui.screens.confirmationScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ConfirmationScreenViewModel: ViewModel() {

    private val _pinTextFlow = MutableStateFlow("")
    var pinTextFlow = _pinTextFlow.asStateFlow()

    fun setTextStateFlow(text: String){
        _pinTextFlow.value = text
    }

    fun confirmPin(){}
}