package com.kardibus.github.data.local.db

import androidx.lifecycle.LiveData
import com.kardibus.github.data.model.db.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbRepository @Inject constructor(private val mAppDatabase: AppDatabase) : DbDataSource {

    override suspend fun insertUser(user: User) = mAppDatabase.articleDao().insert(user)

    override fun allUser(): LiveData<List<User>> {
        return mAppDatabase.articleDao().loadAll()
    }

}