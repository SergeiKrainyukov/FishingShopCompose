package com.example.fishingshopcompose.services

import com.example.fishingshopcompose.api.AuthApi
import com.example.fishingshopcompose.dto.LoginDto
import javax.inject.Inject

class AuthServiceImpl @Inject constructor(private val authApi: AuthApi) : AuthService {
    override suspend fun login(loginDto: LoginDto): String {
        val response = authApi.login(loginDto)
        return if (response.isSuccessful && response.code() == 200) {
            response.body()!!
        } else ("error")
    }
}