package com.zitel.bpmexternalservice.customer

import com.fasterxml.jackson.annotation.JsonProperty
import com.zitel.bpmexternalservice.common.*
import mu.KotlinLogging
import org.springframework.stereotype.Service


@Service
class CustomerPersistenceService(private val bssServiceClient: BssServiceClient) :
    ExecutorService<CustomerPersistenceInputVariable, CustomerPersistenceOutputVariable>() {

    override val type: String = "persist-customer"
    override val description: String = "This service is for persisting customers"

    val log = KotlinLogging.logger { }

    override fun execute(
        processRequestDto: ProcessRequestDto,
        variables: CustomerPersistenceInputVariable
    ): CustomerPersistenceOutputVariable {

//        val test = bssServiceClient.test()
        val test = "test"

        log.info { test }

        log.info { processRequestDto.authorization }

        return CustomerPersistenceOutputVariable(variables.name)
    }


}

data class CustomerPersistenceInputVariable(val name: String,@JsonProperty("full_name") val fullName: String) : InputVariable

data class CustomerPersistenceOutputVariable(val name: String) : OutputVariable
