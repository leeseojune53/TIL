package com.example.helloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloworldApplication

fun main(args: Array<String>) {
    runApplication<HelloworldApplication>(*args)
}
