package com.zitel.bpmexternalservice.service.aggrement

import com.fasterxml.jackson.annotation.JsonProperty
import com.zitel.bpmexternalservice.client.auth.AuthService
import com.zitel.bpmexternalservice.client.bss.BssServiceClient
import com.zitel.bpmexternalservice.client.bss.dto.createdefaultagreementrequest.DefaultAgreementDto
import com.zitel.bpmexternalservice.common.ExecutorService
import com.zitel.bpmexternalservice.common.InputVariable
import com.zitel.bpmexternalservice.common.OutputVariable
import com.zitel.bpmexternalservice.common.ProcessRequestDto
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CreateDefaultAgreementService(
    private val bssServiceClient: BssServiceClient,
    private val authService: AuthService
) :
    ExecutorService<CreateDefaultAgreementInputVariable, CreateDefaultAgreementOutputVariable>() {

    override val type = "create-default-agreement"
    override val description = "This service creates an agreement for a customer and its order"

    val logger = KotlinLogging.logger { }

    override fun execute(
        processRequestDto: ProcessRequestDto,
        variables: CreateDefaultAgreementInputVariable
    ): CreateDefaultAgreementOutputVariable {
        logger.info { "start execute $type service for variables: $variables" }

        return createDefaultAgreement(processRequestDto = processRequestDto, variables = variables)

    }

    fun createDefaultAgreement(
        processRequestDto: ProcessRequestDto,
        variables: CreateDefaultAgreementInputVariable
    ): CreateDefaultAgreementOutputVariable {

        logger.info { "start createDefaultAgreement with processRequestDto: $processRequestDto and variables: $variables" }

        val defaultAgreement = DefaultAgreementDto()

        if (variables.serviceCategory == "ZITEL_FIBER") {
            defaultAgreement.description = "سرویس اینترنت Zitel Fiber  "
        }

        val token = authService.getSystemUserToken()
        logger.info { "createDefaultAgreement ---> authService called successfully" }


        logger.info {
            "createDefaultAgreement ---> call createDefaultAgreement with customerId: ${variables.customerId} and " +
                    " purchaseOrderIid: ${variables.purchaseOrderIid} and body: " +
                    "$defaultAgreement"
        }
        val createDefaultAgreementResponse = bssServiceClient.createDefaultAgreement(
            customerId = variables.customerId,
            orderId = variables.purchaseOrderIid,
            defaultAgreementDto = defaultAgreement,
            token = token
        )

        logger.info { "createDefaultAgreement ---> createDefaultAgreementResponse: $createDefaultAgreementResponse" }

        logger.info { "end createDefaultAgreement with response: $createDefaultAgreementResponse" }

        return CreateDefaultAgreementOutputVariable(
            relationAgreement = createDefaultAgreementResponse.id!!,
            agreementItemId = createDefaultAgreementResponse.agreementItemList[0].id!!
        )

    }

}


data class CreateDefaultAgreementInputVariable(
    @JsonProperty("relation_customer") val customerId: String,
    @JsonProperty("relation_purchase_order_id") val purchaseOrderIid: String,
    @JsonProperty("service_category") val serviceCategory: String
) : InputVariable

data class CreateDefaultAgreementOutputVariable(
    @JsonProperty("relation_agreement") val relationAgreement: String,
    @JsonProperty("agreementItemId") val agreementItemId: String
) : OutputVariable