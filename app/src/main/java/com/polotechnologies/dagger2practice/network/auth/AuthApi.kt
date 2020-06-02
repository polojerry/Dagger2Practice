package com.polotechnologies.dagger2practice.network.auth

import com.polotechnologies.dagger2practice.dataModels.User
import io.reactivex.Flowable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {

    @GET("users/{id}")
    fun getUser(@Path("id") id : Int): Flowable<User>
}