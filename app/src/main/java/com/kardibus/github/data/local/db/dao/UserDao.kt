package com.kardibus.github.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kardibus.github.data.model.db.User


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query(value = "select * from articles")
    fun loadAll(): LiveData<List<User>>
}