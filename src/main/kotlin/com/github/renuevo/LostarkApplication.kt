package com.github.renuevo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

fun main(args: Array<String>) {
    runApplication<LostarkApplication>(*args)
}

@SpringBootApplication
class LostarkApplication
