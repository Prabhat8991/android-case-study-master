package com.target.targetcasestudy.di

import com.target.targetcasestudy.ui.details.DealItemFragment
import com.target.targetcasestudy.ui.dealslist.DealListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeDealListFragment(): DealListFragment

    @ContributesAndroidInjector
    abstract fun contributeDealItemFragment(): DealItemFragment
}