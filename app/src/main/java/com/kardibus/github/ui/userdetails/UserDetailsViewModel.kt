package com.kardibus.github.ui.userdetails

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import com.example.githubapp.models.UserApiResponse
import com.kardibus.github.data.AppDataManager
import com.kardibus.github.data.model.Result
import com.kardibus.github.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class UserDetailsViewModel(
    application: Application,
    appDataManager: AppDataManager
) : BaseViewModel<UserDetailsNavigator>(application, appDataManager) {
    private val usersLiveData: MutableList<UserDetailDataItem> = mutableListOf()


    fun fetchUser(login: String) {
        if (isOnline(application)) {
            viewModelScope.launch {
                setIsLoading(true)
                when (val result = appDataManager.getApiRepository().getUser(login)) {
                    is Result.Success<UserApiResponse> -> {
                        result.data.let { navigator?.setData(mapUsersDataItem(it))}
                        setIsLoading(false)
                    }
                    is Result.Error -> {
                        setIsLoading(false)
                        navigator?.handleError(result.message)
                    }
                }
            }
        }else{
            Toast.makeText(application,"no Connected", Toast.LENGTH_LONG).show()
        }
    }

    private fun isOnline(context: Context): Boolean {
        val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun mapUsersDataItem(users: UserApiResponse): List<UserDetailDataItem> {
            val user= UserDetailDataItem(
                    users.login,
                    users.avatar_url,
                    users.email,
                    users.bio,
                    users.public_repos,
                    users.followers,
                    users.following
            )
            usersLiveData.add(user)

        return usersLiveData
    }
}