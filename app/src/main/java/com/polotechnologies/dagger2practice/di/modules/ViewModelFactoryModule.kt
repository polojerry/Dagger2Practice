package com.polotechnologies.dagger2practice.di.modules

import androidx.lifecycle.ViewModelProvider
import com.polotechnologies.dagger2practice.util.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}