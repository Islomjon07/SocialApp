package com.example.domain.use_case.register

import com.example.domain.models.UserAnswerDomainModel
import com.example.domain.models.UserSignDomainModel

interface UserRegisterUseCase {

    suspend operator fun invoke(
        userSignModel: UserSignDomainModel
    ): Result<UserAnswerDomainModel>
}