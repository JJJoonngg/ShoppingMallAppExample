package com.example.parayo.controller

import com.example.parayo.common.ApiResponse
import com.example.parayo.domain.auth.SignUpRequest
import com.example.parayo.domain.auth.SignUpService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class UserApiController @Autowired constructor(
    private val signUpService: SignUpService
) {
    @PostMapping("/users")
    fun signup(@RequestBody signUpRequest: SignUpRequest) =
        ApiResponse.ok(signUpService.signUp(signUpRequest))
}