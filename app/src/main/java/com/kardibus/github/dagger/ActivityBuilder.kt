package com.kardibus.github.dagger


import com.kardibus.github.ui.MainActivity
import com.kardibus.github.ui.users.UsersFragmentProvider
import com.kardibus.github.ui.userdetails.UserDetailsFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [UsersFragmentProvider::class, UserDetailsFragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity
}