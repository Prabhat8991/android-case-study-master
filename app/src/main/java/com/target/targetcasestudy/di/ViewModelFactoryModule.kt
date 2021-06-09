package com.target.targetcasestudy.di

import androidx.lifecycle.ViewModelProvider
import com.target.targetcasestudy.ui.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}