package org.urhaug.uppercase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UppercaseApplication

fun main(args: Array<String>) {
	runApplication<UppercaseApplication>(*args)
}
