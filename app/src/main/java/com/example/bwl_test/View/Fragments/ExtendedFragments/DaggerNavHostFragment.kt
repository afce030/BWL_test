package com.example.bwl_test.View.Fragments.ExtendedFragments

import android.content.Context
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.bwl_test.di.Factory.injFragmentFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DaggerNavHostFragment : NavHostFragment() {

    @Inject
    protected lateinit var daggerFragmentInjFactory: injFragmentFactory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        childFragmentManager.fragmentFactory = daggerFragmentInjFactory
        super.onCreate(savedInstanceState)
    }
}