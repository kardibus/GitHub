package com.kardibus.github.ui.users

import androidx.databinding.ObservableField
import com.kardibus.core.ui.BaseItemListener

class UsersItemViewModel(
        users: UsersDataItem,
        private val onItemClick: () -> Unit,
) {
    val imageUrl: ObservableField<String?> = ObservableField(users.imageUrl)
    val title: ObservableField<String?> = ObservableField(users.title)
    val login: ObservableField<String?> = ObservableField(users.login)
    val totalCount: ObservableField<String?> = ObservableField(users.total_count)

    fun onItemClick() = onItemClick.invoke()

    interface UsersItemViewModelListener : BaseItemListener<UsersDataItem>
}