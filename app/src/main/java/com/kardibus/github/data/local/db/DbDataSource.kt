package com.kardibus.github.data.local.db

import androidx.lifecycle.LiveData
import com.kardibus.github.data.model.db.User

interface DbDataSource {
    suspend fun insertUser(user: User)
    fun allUser(): LiveData<List<User>>
}