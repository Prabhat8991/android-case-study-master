package com.target.targetcasestudy.di

import android.app.Application
import com.target.targetcasestudy.DealsApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        NetworkModule::class,
        ContextModule::class,
        DatabaseModule::class,
        ViewModelFactoryModule::class
    ]
)
@SuppressWarnings("unchecked")
interface AppComponent: AndroidInjector<DealsApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}