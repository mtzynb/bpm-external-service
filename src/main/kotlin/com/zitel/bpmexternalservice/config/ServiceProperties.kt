package com.zitel.bpmexternalservice.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "service")
class ServiceProperties(
    val client: Client,
    val system: System
) {
    class Client(val timeout: Long, val baseUrl: String)
    class System(val user: String, val pass: String)
}

