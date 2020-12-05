package com.kardibus.github.ui

import androidx.lifecycle.ViewModelProvider
import com.kardibus.github.R
import com.kardibus.github.BR
import com.kardibus.github.ViewModelProviderFactory
import com.kardibus.github.databinding.ActivityMainBinding
import com.kardibus.github.ui.base.BaseActivity
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity :  BaseActivity<ActivityMainBinding, MainViewModel>(),
        HasAndroidInjector {
    @Inject
    lateinit var factory: ViewModelProviderFactory

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel
        get() = ViewModelProvider(this, factory).get(MainViewModel::class.java)
}
