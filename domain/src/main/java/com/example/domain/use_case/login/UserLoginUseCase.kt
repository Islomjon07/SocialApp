package com.example.domain.use_case.login

import com.example.domain.models.UserAnswerDomainModel

interface UserLoginUseCase {

    suspend operator fun invoke(
        username: String,
        userPassword:String
    ): Result<UserAnswerDomainModel>
}