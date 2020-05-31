package com.polotechnologies.dagger2practice.util

import com.polotechnologies.dagger2practice.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class Dagger2PracticeApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build
    }
}