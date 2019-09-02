package com.example.bwl_test.di.DaggerModules.ActivityBuilder

import com.example.bwl_test.View.MainActivity
import com.example.bwl_test.di.DaggerModules.FragmentBuilder.FragmentHostModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule{

    @ContributesAndroidInjector(modules = [FragmentHostModule::class])
    abstract fun mainActivityInjector(): MainActivity

}