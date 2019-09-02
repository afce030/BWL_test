package com.example.bwl_test.di.DaggerModules.FragmentBuilder

import com.example.bwl_test.View.Fragments.ExtendedFragments.DaggerNavHostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentHostModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun navHostFragmentInjector(): DaggerNavHostFragment
}