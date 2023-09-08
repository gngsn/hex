package com.gngsn.hex

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource("classpath:secret.yml")
class HexApplication

fun main(args: Array<String>) {
    runApplication<HexApplication>(*args)
}
