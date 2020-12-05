package com.kardibus.github.ui.userdetails

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UserDetailsFragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideArticleDetailsFragmentFactory(): UserDetailsFragment
}