package com.example.parayo.controller

import com.example.parayo.common.ApiResponse
import com.example.parayo.domain.auth.SignUpRequest
import com.example.parayo.domain.auth.SignUpService
import com.example.parayo.domain.auth.UserContextHolder
import com.example.parayo.domain.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class UserApiController @Autowired constructor(
    private val signUpService: SignUpService,
    private val userService: UserService,
    private val userContextHolder: UserContextHolder
) {
    @PostMapping("/users")
    fun signup(@RequestBody signUpRequest: SignUpRequest) =
        ApiResponse.ok(signUpService.signUp(signUpRequest))

    @PutMapping("/users/fcm-token")
    fun updateFcmToken(@RequestBody fcmToken: String) =
        userContextHolder.id?.let { userId ->
            ApiResponse.ok(userService.updateFcmToken(userId, fcmToken))
        } ?: ApiResponse.error("토큰 갱신 실패")
}