package com.kardibus.github.ui.users

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UsersFragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideArticleFragmentFactory(): UsersFragment
}