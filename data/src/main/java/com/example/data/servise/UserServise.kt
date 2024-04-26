package com.example.data.servise

import com.example.data.models.UserAnswerResponseModel
import com.example.data.models.UserResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

private const val USER_REGISTER_POST = "classes/_User"

interface UserServise {

    @POST(USER_REGISTER_POST)
    suspend fun registerNew(
        @Body userResponseModel: UserResponseModel,
    ): Response<UserAnswerResponseModel>

    @POST(USER_REGISTER_POST)
    suspend fun loginUser(
       @Query("username") userEmail:String,
       @Query("password") userPassword:String,
    ): Response<UserAnswerResponseModel>
}