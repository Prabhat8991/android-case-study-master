package com.target.targetcasestudy.di

import androidx.lifecycle.ViewModel
import com.target.targetcasestudy.di.qualifier.ViewModelKey
import com.target.targetcasestudy.ui.dealslist.DealsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DealsViewModel::class)
    abstract fun provideDealsViewModel(dealsViewModel: DealsViewModel): ViewModel

}