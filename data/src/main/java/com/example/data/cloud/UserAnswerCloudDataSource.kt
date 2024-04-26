package com.example.data.cloud

import com.example.data.models.UserAnswerResponseModel
import com.example.data.models.UserResponseModel

interface UserAnswerCloudDataSource {

    suspend fun register(
        userSignModel: UserResponseModel
    ): Result<UserAnswerResponseModel>

    suspend fun login(
        username: String,
        userPassword:String
    ): Result<UserAnswerResponseModel>

}