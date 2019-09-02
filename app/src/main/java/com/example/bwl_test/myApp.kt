package com.example.bwl_test

import com.example.bwl_test.di.DaggerComponents.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class myApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.builder().create(this)

}