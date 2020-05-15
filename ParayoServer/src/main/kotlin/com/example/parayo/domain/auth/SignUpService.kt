package com.example.parayo.domain.auth

import com.example.parayo.common.ParayoException
import com.example.parayo.domain.user.User
import com.example.parayo.domain.user.UserRepository
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SignUpService @Autowired constructor(
    private val userRepository: UserRepository
) {
    fun signUp(signUpRequest: SignUpRequest) {
        validateRequest(signUpRequest)
        checkDuplicates(signUpRequest.email)
        registerUser(signUpRequest)
    }

    private fun validateRequest(signUpRequest: SignUpRequest) {
        validateEmail(signUpRequest.email)
        validateName(signUpRequest.name)
        validatePassword(signUpRequest.password)
    }

    private fun validateEmail(email: String) {
        val isNotValidEmail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+//.[A-Z]{2,6}$"
            .toRegex(RegexOption.IGNORE_CASE)
            .matches(email)
            .not()

        if (isNotValidEmail) {
            throw ParayoException("이메일 형식이 올바르지 않습니다.")
        }
    }

    private fun validateName(name: String) {
        if (name.trim().length !in 2..20)
            throw ParayoException("이름은 2자 이상 20자 이하여야 합니다.")
    }

    private fun validatePassword(password: String) {
        if (password.trim().length !in 8..20)
            throw ParayoException("비밀번호는 공백을 제외하고 8자 이상 20자 이하여야합니다.")
    }

    private fun checkDuplicates(email: String) =
        userRepository.findByEmail(email)?.let {
            throw ParayoException("이미 사용 중인 이메일 입니다.")
        }

    private fun registerUser(signUpRequest: SignUpRequest) =
        with(signUpRequest) {
            val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
            val user = User(email, hashedPassword, name)
            userRepository.save(user)
        }
}