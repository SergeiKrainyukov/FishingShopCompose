package com.example.fishingshopcompose.dto

import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("code")
    val smsCode: String
)