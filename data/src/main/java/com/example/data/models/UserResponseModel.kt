package com.example.data.models

import com.google.gson.annotations.SerializedName

data class UserResponseModel(
    @SerializedName("username") val userName: String,
    @SerializedName("password") val userPassword: String,
    @SerializedName("firstName") val userFirstName: String,
    @SerializedName("lastName") val userLastName: String,
    @SerializedName("email") val userEmail: String = String(),
    @SerializedName("bio") val userBio: String = String(),
    @SerializedName("userAvatar") val userAvatar: String = String(),
    @SerializedName("location") val userLocation: String = String(),
)
