package com.example.entity.entity.user

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, Int>{
    fun findByName(name: String) : Optional<User>
}