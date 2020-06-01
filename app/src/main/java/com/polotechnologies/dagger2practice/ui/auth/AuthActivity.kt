package com.polotechnologies.dagger2practice.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.polotechnologies.dagger2practice.R
import com.polotechnologies.dagger2practice.viewModel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var logo: Drawable

    @Inject
    lateinit var glideRequestManager: RequestManager

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var authViewModel: AuthViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        authViewModel = ViewModelProvider(this, viewModelProviderFactory)[AuthViewModel::class.java]

        setLogo()
    }

    private fun setLogo() {
        glideRequestManager.load(logo).into(login_logo)
    }
}