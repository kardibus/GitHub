package com.kardibus.github.data.remote.network


import com.example.githubapp.models.ResultUsers
import com.example.githubapp.models.UserApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(ApiEndPoint.ENDPOINT_USER)
    suspend fun getUser(@Path(value = "user") login: String): UserApiResponse

    @GET(ApiEndPoint.ENDPOINT_USERS)
    suspend fun getUsers(@Query(value = "q") login: String, @Query(value = "page") page: Int,@Query(value = "per_page") per:Int): ResultUsers
}