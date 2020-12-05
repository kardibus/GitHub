package com.kardibus.github.ui.userdetails

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.kardibus.github.data.AppDataManager
import com.kardibus.github.data.model.db.User
import com.kardibus.github.ui.users.UsersDataItem
import com.kardibus.github.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class UserDetailsViewModel(
    application: Application,
    appDataManager: AppDataManager
) : BaseViewModel<UserDetailsNavigator>(application, appDataManager) {

    private fun insertArticle(usersDataItem: UsersDataItem) {
        viewModelScope.launch {
            appDataManager.getDbRepository().insertArticle(
                User(
                    usersDataItem.title!!,
                    usersDataItem.login
                    , usersDataItem.imageUrl
                    , usersDataItem.title
                    , usersDataItem.total_count
                    , usersDataItem.content
                )
            )
        }
    }

}