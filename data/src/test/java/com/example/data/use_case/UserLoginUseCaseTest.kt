package com.example.data.use_case

import com.example.domain.models.UserSignDomainModel
import com.example.domain.repository.UserAuthRepository
import com.example.domain.sideEffects.SideEffect
import com.example.domain.use_case.login.UserLoginUseCase
import com.example.domain.use_case.login.UserLoginUseCaseImpl
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class UserLoginUseCaseTest {

    @MockK
    private lateinit var userSignRepository: UserAuthRepository

    @MockK
    private lateinit var showSideEffects: SideEffect
    private lateinit var userLoginUseCase: UserLoginUseCase

    private fun getUserSignTestModel(): UserSignDomainModel.Builder {
        return UserSignDomainModel.Builder()
    }

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        userLoginUseCase = UserLoginUseCaseImpl(
            userSignRepository, showSideEffects
        )
    }

    @Test
    fun `invoke should call makeToast with correct parameters when userLogin isNot Valid`() {
        runBlocking {
            every {
                showSideEffects.makeToast(any())
            } returns Unit

            val userMockKModel = getUserSignTestModel()
                .setEmail("islom07.com")
                .build()

            userLoginUseCase.invoke(userMockKModel)

            verify(exactly = 1) {
                showSideEffects.makeToast("Invalid user Login Email")
            }
        }
    }
    @Test
    fun `invoke should call makeToast with correct parameters when userLoginPassword isNot Valid`() {
        runBlocking {
            every {
                showSideEffects.makeToast(any())
            } returns Unit

            val userMockKModel = getUserSignTestModel()
                .setEmail("islom07@gmail.com")
                .setPassword("0")
                .build()

            userLoginUseCase.invoke(userMockKModel)

            verify(exactly = 1) {
                showSideEffects.makeToast("Invalid user Login password")
            }
        }
    }

    @After
    fun clearAllMocks() {
        unmockkAll()
    }
}

