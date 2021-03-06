package com.polotechnologies.dagger2practice.di.components

import android.app.Application
import com.polotechnologies.dagger2practice.di.modules.AppModule
import com.polotechnologies.dagger2practice.di.modules.ViewModelFactoryModule
import com.polotechnologies.dagger2practice.di.modules.builder.ActivityModuleBuilder
import com.polotechnologies.dagger2practice.util.Dagger2PracticeApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class, ActivityModuleBuilder::class,
        AppModule::class, ViewModelFactoryModule::class]
)
interface AppComponent : AndroidInjector<Dagger2PracticeApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        val build: AppComponent

    }
}