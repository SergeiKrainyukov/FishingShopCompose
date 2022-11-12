package com.example.fishingshopcompose.ui.screens.getCodeScreen

import androidx.lifecycle.ViewModel

class GetCodeScreenViewModel: ViewModel() {
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