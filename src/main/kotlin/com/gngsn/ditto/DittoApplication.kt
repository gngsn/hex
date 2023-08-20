package com.gngsn.ditto

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource("classpath:secret.yml")
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
