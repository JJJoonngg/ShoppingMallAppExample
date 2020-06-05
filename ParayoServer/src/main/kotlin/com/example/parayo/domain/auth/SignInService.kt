package com.example.parayo.domain.auth

import com.example.parayo.common.ParayoException
import com.example.parayo.domain.user.User
import com.example.parayo.domain.user.UserRepository
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.IllegalStateException

@Service
class SignInService @Autowired constructor(
    private val userRepository: UserRepository
) {
    fun signIn(signInRequest: SignInRequest): SignInResponse {
        val user = userRepository
            .findByEmail(signInRequest.email.toLowerCase())
            ?: throw ParayoException("로그인 정보를 확인해주세요.")

        if (isNotValidPassword(signInRequest.password, user.password)) {
            throw ParayoException("로그인 정보를 확인해주세요.")
        }
        user.fcmToken = signInRequest.fcmToken
        userRepository.save(user)
        
        return responseWithTokens(user)
    }

    private fun isNotValidPassword(
        plain: String,
        hashed: String
    ) = BCrypt.checkpw(plain, hashed).not()

    private fun responseWithTokens(user: User) = user.id?.let { userId ->
        SignInResponse(
            JWTUtil.createToken(user.email),
            JWTUtil.createRefreshToken(user.email),
            user.name,
            userId
        )
    } ?: throw IllegalStateException("user.id 없음.")
}