package com.example.fishingshopcompose.ui.screens.confirmationScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fishingshopcompose.dto.LoginDto
import com.example.fishingshopcompose.services.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfirmationScreenViewModel @Inject constructor(
    private val authService: AuthService
) : ViewModel() {

    private val _pinTextFlow = MutableStateFlow("")
    val pinTextFlow = _pinTextFlow.asStateFlow()

    private val _confirmPinFlow = MutableStateFlow("")
    val confirmPinFlow = _confirmPinFlow.asStateFlow()

    fun updateTextFlow(text: String) {
        _pinTextFlow.value = text
        confirmPin()
    }

    fun confirmPin() {
        if (_pinTextFlow.value.length == PIN_TEXT_LENGTH)
            viewModelScope.launch {
                val result = authService.login(LoginDto(_pinTextFlow.value))
                if (result == "success") _confirmPinFlow.emit(result)
            }
    }

    companion object {
        const val PIN_TEXT_LENGTH = 4
    }
}