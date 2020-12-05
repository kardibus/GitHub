package com.kardibus.github.data.remote

import com.example.githubapp.models.ResultUsers
import com.example.githubapp.models.UserApiResponse
import com.kardibus.github.data.model.Result


interface ApiDataSource {
    suspend fun getUser(login: String): Result<UserApiResponse>
    suspend fun getUsers(login: String,page:Int,per:Int): Result<ResultUsers>
}