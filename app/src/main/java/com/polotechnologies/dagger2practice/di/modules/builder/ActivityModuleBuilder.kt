package com.polotechnologies.dagger2practice.di.modules.builder

import com.polotechnologies.dagger2practice.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModuleBuilder  {

    @ContributesAndroidInjector
    abstract fun contributeAuthActivity(): AuthActivity
}