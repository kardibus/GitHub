package com.kardibus.github.data.remote

import android.content.Context
import android.net.ConnectivityManager
import com.example.githubapp.models.ResultUsers
import com.example.githubapp.models.UserApiResponse
import com.kardibus.github.data.model.Result
import com.kardibus.github.data.remote.network.ApiService
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor( private val apiService: ApiService) : ApiDataSource {

    override suspend fun getUser(login: String): Result<UserApiResponse> {
        return try {
            val usersResponse = apiService.getUser(login)
            Result.Success(usersResponse)
        }catch (e:Exception){
            Result.Error(e.message)
        }
    }

    override suspend fun getUsers(login: String, page: Int,per:Int): Result<ResultUsers> {
      return try {
          val usersResponse = apiService.getUsers(login,page,per)
          Result.Success(usersResponse)
      }catch (e:Exception){
          Result.Error(e.message)
      }
    }

}