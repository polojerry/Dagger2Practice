package com.polotechnologies.dagger2practice.di.components

import android.app.Application
import com.polotechnologies.dagger2practice.util.Dagger2PracticeApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<Dagger2PracticeApplication>{

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application)  : Builder

        val build : AppComponent

    }
}