package com.target.targetcasestudy.di

import com.target.targetcasestudy.ui.dealslist.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [FragmentBindingModule::class, ViewModelModule::class])
    abstract fun contributeMainActivity(): MainActivity
}