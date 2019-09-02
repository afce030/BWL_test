package com.example.bwl_test.di.DaggerComponents

import com.example.bwl_test.di.DaggerModules.*
import com.example.bwl_test.di.DaggerModules.ActivityBuilder.ActivityModule
import com.example.bwl_test.di.DaggerModules.ViewModelBuilders.ViewModelModule
import com.example.bwl_test.myApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        AppModule::class,
        RepoModule::class,
        ViewModelModule::class,
        RetrofitModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<myApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<myApp>() {

        abstract override fun build(): ApplicationComponent
    }
}