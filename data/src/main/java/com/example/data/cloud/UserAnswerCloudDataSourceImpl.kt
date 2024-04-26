package com.example.data.cloud

import com.example.data.base.BaseDataSource
import com.example.data.models.UserAnswerResponseModel
import com.example.data.models.UserResponseModel
import com.example.data.servise.UserServise
import com.example.domain.models.UserAnswerDomainModel
import com.example.domain.models.UserSignDomainModel
import javax.inject.Inject

class UserAnswerCloudDataSourceImpl @Inject constructor(
    private val servise: UserServise
) : UserAnswerCloudDataSource ,BaseDataSource(){
    override suspend fun register(
        userSignModel: UserResponseModel
    ): Result<UserAnswerResponseModel>  = invokeResponseRequest {
        servise.registerNew(userSignModel)
    }

    override suspend fun login(
        username: String,
        userPassword: String
    ): Result<UserAnswerResponseModel> = invokeResponseRequest {
        servise.loginUser(username,userPassword)
    }
}