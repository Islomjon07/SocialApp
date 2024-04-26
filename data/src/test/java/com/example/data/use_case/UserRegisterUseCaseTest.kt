package com.example.data.use_case

import com.example.domain.models.UserSignDomainModel
import com.example.domain.repository.UserAuthRepository
import com.example.domain.sideEffects.SideEffect
import com.example.domain.use_case.register.UserRegisterUseCase
import com.example.domain.use_case.register.UserRegisterUseCaseImpl
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class UserRegisterUseCaseTest {

    @MockK
    private lateinit var userSignRepository: UserAuthRepository

    @MockK
    private lateinit var showSideEffects: SideEffect
    private lateinit var userRegisterUseCase: UserRegisterUseCase

    private fun getUserSignTestModel(): UserSignDomainModel.Builder {
        return UserSignDomainModel.Builder()
    }

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        userRegisterUseCase = UserRegisterUseCaseImpl(
            userSignRepository, showSideEffects
        )
    }

    @Test
    fun `invoke should call makeToast with correct parameters when userFirstName isNot Valid`() {
        runBlocking {
            every {

                showSideEffects.makeToast(any())
            } returns Unit

            val userMockKModel = getUserSignTestModel()
                .setFirstName("a")
                .build()

            userRegisterUseCase.invoke(userMockKModel)

            verify(exactly = 1) {
                showSideEffects.makeToast("Invalid user firstName")
            }
        }
    }

    @Test
    fun `invoke should call makeToast with correct parameters when userLastName isNot Valid`() {
        runBlocking {
            every {

                showSideEffects.makeToast(any())
            } returns Unit

            val userMockKModel = getUserSignTestModel()
                .setFirstName("ksdfdfd")
                .setLastName("12")
                .build()

            userRegisterUseCase.invoke(userMockKModel)

            verify(exactly = 1) {
                showSideEffects.makeToast("Invalid user lastName")
            }
        }
    }
    @Test
    fun `invoke should call makeToast with correct parameters when userEmail isNot Valid`() {
        runBlocking {
            every {
                showSideEffects.makeToast(any())
            } returns Unit

            val userMockKModel = getUserSignTestModel()
                .setFirstName("Islam")
                .setLastName("hjhgjkh")
                .setEmail("islom07@.gmail.com")
                .build()

            userRegisterUseCase.invoke(userMockKModel)

            verify(exactly = 1) {
                showSideEffects.makeToast("Invalid user email")
            }
        }
    }
    @Test
    fun `invoke should call makeToast with correct parameters when userPassword isNot Valid`() {
        runBlocking {
            every {
                showSideEffects.makeToast(any())
            } returns Unit

            val userMockKModel = getUserSignTestModel()
                .setFirstName("Islam")
                .setLastName("hjhkh")
                .setEmail("islom07@gmail.com")
                .setPassword("2")
                .build()

            userRegisterUseCase.invoke(userMockKModel)

            verify(exactly = 1) {
                showSideEffects.makeToast("Invalid user password")
            }
        }
    }

    @After
    fun clearAllMocks() {
        unmockkAll()
    }
}

