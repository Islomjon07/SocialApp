package com.example.domain.use_case.login

import com.example.domain.models.UserAnswerDomainModel
import com.example.domain.repository.UserAuthRepository
import com.example.domain.sideEffects.SideEffect
import com.example.domain.utils.isValidEmail

class UserLoginUseCaseImpl(
    private val repository: UserAuthRepository,
    private val sideEffect: SideEffect
) : UserLoginUseCase {
    override suspend fun invoke(
        username: String,
        userPassword: String
    ): Result<UserAnswerDomainModel> {
        if (!username.isValidEmail()) {
            sideEffect.makeToast("Invalid user Login Email")
        }
        if (userPassword.trim().length < 8) {
            sideEffect.makeToast("Invalid user Login password")
        }
        return repository.login(username, userPassword)
    }
}
