package com.example.domain.use_case.register

import com.example.domain.models.UserAnswerDomainModel
import com.example.domain.models.UserSignDomainModel
import com.example.domain.repository.UserAuthRepository
import com.example.domain.sideEffects.SideEffect
import com.example.domain.utils.isValidEmail
import com.example.domain.utils.validateUserNames

class UserRegisterUseCaseImpl(
    private val repository: UserAuthRepository,
    private val sideEffect: SideEffect
) : UserRegisterUseCase {
    override suspend fun invoke(
        userSignModel: UserSignDomainModel
    ): Result<UserAnswerDomainModel> {
        if (!userSignModel.userFirstName.validateUserNames()) {
            sideEffect.makeToast("Invalid user firstName")
            repository.register(userSignModel)
        }
        if (!userSignModel.userLastName.validateUserNames()) {
            sideEffect.makeToast("Invalid user lastName")
            repository.register(userSignModel)
        }
        if (!userSignModel.userEmail.isValidEmail()) {
            sideEffect.makeToast("Invalid user email")
            repository.register(userSignModel)
        }
        if (userSignModel.userPassword.trim().length < 8) {
            sideEffect.makeToast("Invalid user password")
            repository.register(userSignModel)
        }
        return repository.register(userSignModel)
    }
}