package com.example.domain.utils

import java.util.regex.Pattern


fun String.isValidEmail(): Boolean {
    return Pattern.compile(
        "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@" +
                "((([0-9]{1,3}\\.){3}[0-9]{1,3})|(([a-zA-Z]+\\.)+[a-zA-Z]{2,}))$"
    ).matcher(this).matches()
}

fun String.validateUserNames(): Boolean {
    return this.trim().length != 1 && this.any { !it.isDigit() }
}
