package com.polotechnologies.dagger2practice.di.auth

import com.polotechnologies.dagger2practice.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule {

    @Provides
    fun provideAuthApi(retrofit: Retrofit)  :AuthApi{
        return retrofit.create(AuthApi::class.java)
    }
}