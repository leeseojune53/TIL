package com.example.entity.entity.user

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User(
        val password: String = "",
        val name: String = "",
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = -1)
