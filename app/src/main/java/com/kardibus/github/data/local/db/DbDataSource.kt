package com.kardibus.github.data.local.db

import androidx.lifecycle.LiveData
import com.kardibus.github.data.model.db.User

interface DbDataSource {
    suspend fun insertArticle(user: User)
    fun allArticles(): LiveData<List<User>>
}