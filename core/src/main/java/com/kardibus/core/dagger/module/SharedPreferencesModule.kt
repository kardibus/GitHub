package com.kardibus.core.dagger.module

import android.content.Context
import android.content.SharedPreferences
import com.kardibus.core.dagger.annotation.FeatureScope
import dagger.Module
import dagger.Provides

@Module
class SharedPreferencesModule(val context:Context,val name:String) {

    @Provides
    @FeatureScope
    fun provideSharedPreferences(): SharedPreferences =
        context.applicationContext.getSharedPreferences(name,Context.MODE_PRIVATE)
}