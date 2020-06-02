package com.polotechnologies.dagger2practice.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.polotechnologies.dagger2practice.R
import com.polotechnologies.dagger2practice.util.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity(), View.OnClickListener {

    @Inject
    lateinit var logo: Drawable

    @Inject
    lateinit var glideRequestManager: RequestManager

    @Inject
    lateinit var viewModelProviderFactory : ViewModelProviderFactory

    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        authViewModel = ViewModelProvider(this, viewModelProviderFactory).get(AuthViewModel::class.java)
        login_button.setOnClickListener(this)
        setLogo()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        authViewModel.observeUser().observe(this, Observer {user->
            if(user!=null){
                Log.d(Companion.TAG, "subscribeObservers: User Email ${user.email}")
            }

        })
    }

    private fun setLogo() {
        glideRequestManager.load(logo).into(login_logo)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.login_button-> attemptLogin()
        }
    }

    private fun attemptLogin() {
        if(user_id_input.text.isNullOrEmpty()){
            return
        }

        authViewModel.authenticateWithId(user_id_input.text.toString().toInt())


    }

    companion object {
        private const val TAG = "AuthActivity"
    }

}