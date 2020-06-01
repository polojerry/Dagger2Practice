package com.polotechnologies.dagger2practice.di.modules

import androidx.lifecycle.ViewModelProvider
import com.polotechnologies.dagger2practice.viewModel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelProvider: ViewModelProviderFactory): ViewModelProvider.Factory

}