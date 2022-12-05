package com.zitel.bpmexternalservice.config

import com.zitel.bpmexternalservice.common.BssServiceClient
import com.zitel.bpmexternalservice.common.auth.AuthServiceClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import java.time.Duration

@Configuration
class HttpClientConfiguration(private val properties: ServiceProperties) {

    @Bean
    fun webClient(): WebClient = WebClient.builder().baseUrl(properties.client.baseUrl).build()

    @Bean
    fun bssServiceClient(): BssServiceClient {

        return HttpServiceProxyFactory
            .builder()
            .clientAdapter(WebClientAdapter.forClient(webClient()))
            .blockTimeout(Duration.ofMillis(properties.client.timeout))
            .build()
            .createClient(BssServiceClient::class.java)
    }

    @Bean
    fun authServiceClient(): AuthServiceClient {
        return HttpServiceProxyFactory
            .builder()
            .clientAdapter(WebClientAdapter.forClient(webClient()))
            .blockTimeout(Duration.ofMillis(properties.client.timeout))
            .build()
            .createClient(AuthServiceClient::class.java)
    }
}