package com.example.fishingshopcompose.api

import com.example.fishingshopcompose.dto.LoginDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/login")
    suspend fun login(@Body loginDto: LoginDto): Response<String>
}