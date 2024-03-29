package io.github.leeseojune53.kopring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class KopringApplication

fun main(args: Array<String>) {
	runApplication<KopringApplication>(*args)
}
