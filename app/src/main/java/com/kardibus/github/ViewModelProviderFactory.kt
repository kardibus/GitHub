package com.kardibus.github

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.kardibus.github.ui.users.UsersViewModel
import com.kardibus.github.ui.userdetails.UserDetailsViewModel
import com.kardibus.github.ui.MainViewModel
import com.kardibus.github.data.AppDataManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject constructor(
    private val application: Application,
    private val appDataManager: AppDataManager
) : NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(application, appDataManager) as T
            }
            modelClass.isAssignableFrom(UsersViewModel::class.java) -> {
                UsersViewModel(application, appDataManager) as T
            }
            modelClass.isAssignableFrom(UserDetailsViewModel::class.java) -> {
                UserDetailsViewModel(application, appDataManager) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}