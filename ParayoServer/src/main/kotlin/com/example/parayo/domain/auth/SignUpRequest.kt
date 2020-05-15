package com.example.parayo.domain.auth

data class SignUpRequest(
    val email: String,
    val name: String,
    val password: String
)