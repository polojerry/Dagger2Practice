package com.polotechnologies.dagger2practice.ui.auth

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.polotechnologies.dagger2practice.dataModels.User
import com.polotechnologies.dagger2practice.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@SuppressLint("CheckResult")
class AuthViewModel
@Inject constructor(private val authApi: AuthApi) : ViewModel() {

    private val authUser = MediatorLiveData<User>()

    init {
        Log.d(TAG, "Init:ViewModel is Working ")
    }

    fun authenticateWithId(id : Int) {
        val source : LiveData<User> =  LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(id)
                .subscribeOn(Schedulers.io())
        )

        authUser.addSource(source) { user->
            authUser.value = user
            authUser.removeSource(source)
        }
    }

    fun observeUser()  :LiveData<User>{
        return authUser
    }


    companion object {
        private const val TAG = "AuthViewModel"
    }

}