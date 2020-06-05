package com.example.parayo.domain.user

import com.example.parayo.domain.jpa.BaseEntity
import java.util.*
import javax.persistence.*

@Entity(name = "user")
class User(
    var email: String,
    var password: String,
    var name: String,
    var fcmToken: String?
) : BaseEntity()