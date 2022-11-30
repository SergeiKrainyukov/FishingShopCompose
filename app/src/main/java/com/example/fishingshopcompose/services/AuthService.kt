package com.example.fishingshopcompose.services

import com.example.fishingshopcompose.dto.LoginDto

interface AuthService {
    suspend fun login(loginDto: LoginDto): String
}