package com.polotechnologies.dagger2practice.di.modules.builder

import com.polotechnologies.dagger2practice.di.auth.AuthViewModelModule
import com.polotechnologies.dagger2practice.ui.auth.AuthActivity
import com.polotechnologies.dagger2practice.ui.auth.AuthViewModel
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModuleBuilder  {

    @ContributesAndroidInjector(modules = [AuthViewModelModule::class])
    abstract fun contributeAuthActivity(): AuthActivity
}