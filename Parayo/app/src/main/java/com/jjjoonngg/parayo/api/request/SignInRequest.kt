package com.jjjoonngg.parayo.api.request

import android.util.Patterns
import com.jjjoonngg.parayo.common.Prefs

class SignInRequest(
    val email: String?,
    val password: String?,
    val fcmToken: String? = Prefs.fcmToken
) {
    fun isNotValidEmail() =
        email.isNullOrBlank()
                || !Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isNotValidPassword() =
        password.isNullOrBlank() || password.length !in 8..20
}