package com.example.socialapp.di

import android.content.Context
import com.example.data.sideEffects.SideEffectImpl
import com.example.domain.repository.UserAuthRepository
import com.example.domain.sideEffects.SideEffect
import com.example.domain.use_case.login.UserLoginUseCase
import com.example.domain.use_case.login.UserLoginUseCaseImpl
import com.example.domain.use_case.register.UserRegisterUseCase
import com.example.domain.use_case.register.UserRegisterUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideUserRegisterUseCase(
        authRepository: UserAuthRepository,
        sideEffect: SideEffect
    ): UserRegisterUseCase = UserRegisterUseCaseImpl(authRepository, sideEffect)

    @Provides
    fun provideUserLoginUseCase(
        authRepository: UserAuthRepository,
        sideEffect: SideEffect
    ): UserLoginUseCase = UserLoginUseCaseImpl(authRepository, sideEffect)

    @Provides
    fun provideSideEffect(
        @ApplicationContext context: Context
    ): SideEffect = SideEffectImpl(context)
}