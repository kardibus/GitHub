package com.kardibus.github.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kardibus.github.data.local.db.dao.UserDao
import com.kardibus.github.data.model.db.User

@Database(
    entities = [User::class],
    version = 1,exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao(): UserDao
}