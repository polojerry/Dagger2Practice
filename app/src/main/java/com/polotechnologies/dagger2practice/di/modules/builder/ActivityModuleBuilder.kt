package com.polotechnologies.dagger2practice.di.modules.builder

import com.polotechnologies.dagger2practice.di.auth.AuthModule
import com.polotechnologies.dagger2practice.di.auth.AuthViewModelModule
import com.polotechnologies.dagger2practice.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModuleBuilder  {

    @ContributesAndroidInjector(modules = [AuthViewModelModule::class, AuthModule::class])
    abstract fun contributeAuthActivity(): AuthActivity
}