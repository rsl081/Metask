package com.s2dioapps.metask.utils

import java.util.regex.Pattern

object RegexUtils {

    private val PASSWORD: Pattern = Pattern.compile(
        "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$"
    )
    fun isValidPassword(email: String): Boolean {
        return PASSWORD.matcher(email).matches()
    }

}