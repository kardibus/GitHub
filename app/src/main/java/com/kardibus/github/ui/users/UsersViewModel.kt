package com.kardibus.github.ui.users

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import com.example.githubapp.models.ResultUsers
import com.kardibus.github.data.AppDataManager
import com.kardibus.github.data.model.Result
import com.kardibus.github.data.model.db.User
import com.kardibus.github.ui.base.BaseViewModel
import kotlinx.coroutines.launch


class UsersViewModel(
    application: Application,
    appDataManager: AppDataManager
) : BaseViewModel<UsersNavigator>(application, appDataManager) {

    private val usersLiveData: MutableList<UsersDataItem> = mutableListOf()

    fun onBackClick(){
        usersLiveData.clear()
        navigator?.back()
    }

    fun onMoreClick(){
        usersLiveData.clear()
        navigator?.more()
    }

    fun onSearchClick(){
        usersLiveData.clear()
        navigator?.search()
    }

    fun fetchUsers(login: String, page: Int, per:Int) {
        if (isOnline(application)) {
            viewModelScope.launch {
                setIsLoading(true)
                when (val result = appDataManager.getApiRepository().getUsers(login, page, per)) {
                    is Result.Success<ResultUsers> -> {
                        result.data.let { navigator?.setData(mapUsersDataItem(it)) }
                        setIsLoading(false)
                    }
                    is Result.Error -> {
                        setIsLoading(false)
                        navigator?.handleError(result.message)
                    }
                }
            }
        }else{
            Toast.makeText(application,"no Connected",Toast.LENGTH_LONG).show()
        }
    }


    private fun isOnline(context: Context): Boolean {
        val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun mapUsersDataItem(users: ResultUsers): List<UsersDataItem> {

        for (userDataItem in users.items!!) {
            val user= UsersDataItem(
                userDataItem.login
                , userDataItem.avatar_url
                , userDataItem.node_id
                , userDataItem.gravatar_id
                , userDataItem.url)
            insertArticle(user)
            usersLiveData.add(user)
        }

        return usersLiveData
    }

    private fun insertArticle(articleDataItem: UsersDataItem) {
        viewModelScope.launch {
            appDataManager.getDbRepository().insertArticle(
                User(
                    articleDataItem.title!!,
                    articleDataItem.login
                    , articleDataItem.imageUrl
                    , articleDataItem.title
                    , articleDataItem.total_count
                    , articleDataItem.content
                )
            )
        }
    }

}