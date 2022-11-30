package com.example.fishingshopcompose.di

import com.example.fishingshopcompose.services.AuthService
import com.example.fishingshopcompose.services.AuthServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    @Binds
    @Singleton
    abstract fun bindAuthService(
        authService: AuthServiceImpl
    ): AuthService
}