package com.example.bwl_test.di.DaggerModules

import android.app.Application
import com.example.bwl_test.myApp
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindApplication(app: myApp): Application

}