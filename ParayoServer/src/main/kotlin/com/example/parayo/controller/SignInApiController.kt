package com.example.parayo.controller

import com.example.parayo.common.ApiResponse
import com.example.parayo.domain.auth.SignInRequest
import com.example.parayo.domain.auth.SignInService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class SignInApiController @Autowired constructor(
    private val signInService: SignInService
) {

    @PostMapping("/signin")
    fun signIn(@RequestBody signInRequest: SignInRequest) =
        ApiResponse.ok(signInService.signIn(signInRequest))
}