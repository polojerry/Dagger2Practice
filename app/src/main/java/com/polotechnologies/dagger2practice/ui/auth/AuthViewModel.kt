package com.polotechnologies.dagger2practice.ui.auth

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import com.polotechnologies.dagger2practice.dataModels.User
import com.polotechnologies.dagger2practice.network.auth.AuthApi
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@SuppressLint("CheckResult")
class AuthViewModel
@Inject constructor(authApi: AuthApi) : ViewModel() {

    init {
        Log.d(TAG, "Init: ViewModel Injected..... ")
        authApi.getUser(2)
            .toObservable()
            .subscribeOn(Schedulers.io())
            .subscribe {user->

                Log.d(TAG, "onNext: UserEmail: ${user.email}")
                object : Observer<User> {
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(user: User) {
                        Log.d(TAG, "onNext: UserEmail: ${user.email}")
                    }

                    override fun onError(e: Throwable) {
                        Log.d(TAG, "Error: ${e.localizedMessage}")
                    }

                }
            }
    }

    companion object {
        private const val TAG = "AuthViewModel"
    }

}