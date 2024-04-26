package com.example.data.mappers

import com.example.data.models.UserAnswerResponseModel
import com.example.data.models.UserResponseModel
import com.example.domain.models.UserAnswerDomainModel
import com.example.domain.models.UserSignDomainModel

fun UserSignDomainModel.toData() =  UserResponseModel(
    userName = userName,
    userPassword = userPassword,
    userEmail = userEmail,
    userFirstName = userFirstName,
    userLastName = userLastName
)

fun UserAnswerResponseModel.toDomain() = UserAnswerDomainModel(
    objectId = objectId,
    userAvatar = userAvatar.orEmpty(),
)