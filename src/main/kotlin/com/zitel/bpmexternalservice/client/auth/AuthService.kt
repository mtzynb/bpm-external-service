package com.zitel.bpmexternalservice.client.auth

import com.zitel.bpmexternalservice.config.ServiceProperties
import org.springframework.stereotype.Service

@Service
class AuthService(private val authService: AuthServiceClient, private val serviceProperties: ServiceProperties) {
    companion object {
        const val PASSWORD = "password"
        const val AUTHORIZATION = "Basic ZnJvbnRlbmQ6dmVyeS1zZWNyZXQ="
    }

    fun getSystemUserToken(): String {
        val system = serviceProperties.system
        val serviceToken = authService.serviceToken(system.user, system.pass, PASSWORD, AUTHORIZATION)
        return serviceToken["token_type"] + " " + serviceToken["access_token"]
    }
}