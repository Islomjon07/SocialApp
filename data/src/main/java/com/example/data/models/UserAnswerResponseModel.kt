package com.example.data.models

data class  UserAnswerResponseModel(
    val objectId: String,
    val userAvatar: String? = null,
){
    companion object{
        val unknown = UserAnswerResponseModel(
            objectId = "",
            userAvatar = ""
        )
    }
}
