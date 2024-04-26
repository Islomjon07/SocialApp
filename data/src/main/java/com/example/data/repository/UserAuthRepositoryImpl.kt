package com.example.data.repository

import com.example.data.base.BaseDataSource
import com.example.data.mappers.toData
import com.example.data.mappers.toDomain
import com.example.data.servise.UserServise
import com.example.domain.models.UserAnswerDomainModel
import com.example.domain.models.UserSignDomainModel
import com.example.domain.repository.UserAuthRepository
import javax.inject.Inject

class UserAuthRepositoryImpl @Inject constructor(
    private val servise: UserServise
) : UserAuthRepository, BaseDataSource() {

    override suspend fun register(
        userSignModel: UserSignDomainModel
    ): Result<UserAnswerDomainModel> {
        val response = invokeResponseRequest {
            servise.registerNew(userSignModel.toData())
        }
        return response.map { it.toDomain() }
    }

    override suspend fun login(
        username: String,
        userPassword: String
    ): Result<UserAnswerDomainModel> {
        val response = invokeResponseRequest {
            servise.loginUser(username,userPassword)
        }
        return response.map { it.toDomain() }
    }
}