package com.example.domain.models

data class UserSignDomainModel(
    val userName: String,
    val userPassword: String,
    val userEmail: String = String(),
    val userFirstName: String,
    val userLastName: String,
    val userBio: String = String()  ,
    val userAvatar: String = String(),
    val userLocation: String = String(),
) {
    companion object {
        val NONE = UserSignDomainModel(
            userName = String(),
            userPassword = String(),
            userEmail = String(),
            userFirstName = String(),
            userLastName = String(),
            userAvatar = String(),
            userBio = String(),
            userLocation = String(),
        )
    }

    constructor(builder: Builder) : this(
        userFirstName = builder.userFirstName,
        userLastName = builder.userLastName,
        userEmail = builder.userEmail,
        userPassword = builder.userPassword,
        userBio = String(),
        userAvatar = String(),
        userLocation = String(),
        userName = String(),
    )

    class Builder {
        var userFirstName = String()

        var userLastName = String()

        var userEmail = String()

        var userPassword = String()

        fun setFirstName(userName: String) = apply { this.userFirstName = userName }
        fun setLastName(userName: String) = apply { this.userLastName = userName }
        fun setEmail(userName: String) = apply { this.userEmail = userName }
        fun setPassword(userName: String) = apply { this.userPassword = userName }

        fun build() = UserSignDomainModel(this)
    }
}

