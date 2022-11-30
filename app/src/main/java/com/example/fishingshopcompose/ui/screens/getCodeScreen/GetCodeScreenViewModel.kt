package com.example.fishingshopcompose.ui.screens.getCodeScreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class GetCodeScreenViewModel @Inject constructor(): ViewModel() {

    private val _phoneTextFlow = MutableStateFlow("")
    var phoneTextFlow = _phoneTextFlow.asStateFlow()

    fun setTextStateFlow(text: String){
        _phoneTextFlow.value = text
    }

    fun checkPhoneNumberLength(text: String): Boolean {
        if (text.startsWith("+") && text.length <= 12) return true
        if (text.length <= 11) return true
        return false
    }

    fun validatePhoneNumber(text: String): Boolean {
        if (text.startsWith("+") && text.length < 12) return false
        if (text.length < 11) return false
        return true
    }
}