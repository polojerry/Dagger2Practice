package com.polotechnologies.dagger2practice.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor()  :ViewModel() {
    init {
        Log.d(TAG, "ViewModelWorking: ")
    }

    companion object {
        private const val TAG = "AuthViewModel"
    }
}