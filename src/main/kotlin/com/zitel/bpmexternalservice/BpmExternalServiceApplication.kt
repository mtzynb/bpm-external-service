package com.zitel.bpmexternalservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class BpmExternalServiceApplication

fun main(args: Array<String>) {
    runApplication<BpmExternalServiceApplication>(*args)
}
