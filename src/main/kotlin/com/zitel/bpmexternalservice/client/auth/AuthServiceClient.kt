package com.zitel.bpmexternalservice.client.auth

import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PostExchange

@HttpExchange("auth-service")
interface AuthServiceClient {

    @PostExchange(url = "/oauth/token")
    fun serviceToken(
        @RequestParam(name = "username") username:String,
        @RequestParam(name = "password") password:String,
        @RequestParam(name = "grant_type") grantType:String,
        @RequestHeader(HttpHeaders.AUTHORIZATION) authorization: String
    ): Map<String, String>
}
