package com.example.parayo.domain.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.IllegalStateException

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
){

    fun updateFcmToken(userId:Long, fcmToken:String)=
        userRepository.findByIdOrNull(userId)?.run{
            this.fcmToken = fcmToken
            userRepository.save(this)
        }?: throw IllegalStateException("사용자 정보 없음")
}