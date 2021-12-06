package io.github.leeseojune53.kopring.domain.user.domain

import org.jetbrains.annotations.NotNull
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User(
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		val id: Long = 0,

		@NotNull
		val name: String,

		@Column(length = 60)
		@NotNull
		val password: String,
)