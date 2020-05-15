package com.example.parayo.domain.auth

data class SignInRequest(
    val email: String,
    val password: String
)