package com.target.targetcasestudy.di

import android.app.Application
import android.content.Context
import com.target.targetcasestudy.domain.usecase.DefaultDispatcherProvider
import com.target.targetcasestudy.domain.usecase.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideDispatcher(): DispatcherProvider = DefaultDispatcherProvider()
}