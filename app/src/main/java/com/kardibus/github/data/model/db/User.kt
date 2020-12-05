package com.kardibus.github.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
class User(
    @field:PrimaryKey val id: String="ID",
    @field:ColumnInfo(name = "author") val login: String?,
    @field:ColumnInfo(name = "imageUrl") val imageUrl: String?,
    @field:ColumnInfo(name = "title") val title: String?,
    @field:ColumnInfo(name = "publishedDate") val publishedDate: String?,
    @field:ColumnInfo(name = "content") val content: String?
)