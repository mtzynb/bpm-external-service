package com.zitel.bpmexternalservice.service.contract

import com.fasterxml.jackson.annotation.JsonProperty
import com.zitel.bpmexternalservice.client.bss.BssServiceClient
import com.zitel.bpmexternalservice.common.*
import com.zitel.bpmexternalservice.client.auth.AuthService
import com.zitel.bpmexternalservice.client.bss.dto.createfullcontractrequest.AgreementProductDto
import com.zitel.bpmexternalservice.client.bss.dto.createfullcontractrequest.ContractAgreementDto
import com.zitel.bpmexternalservice.client.bss.dto.createfullcontractrequest.Specification
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CreateFullContractService(
    private val bssServiceClient: BssServiceClient,
    private val authService: AuthService
) : ExecutorService<CreateFullContractInputVariable, CreateFullContractOutputVariable>() {
    override val type = "create-full-contract"
    override val description = "This service creates a full contract based on customer order"

    val logger = KotlinLogging.logger { }

    override fun execute(
        processRequestDto: ProcessRequestDto,
        variables: CreateFullContractInputVariable
    ): CreateFullContractOutputVariable {
        logger.info { "start execute $type service for variables: $variables" }

        return createFullContract(processRequestDto = processRequestDto, variables = variables)
    }

    fun createFullContract(
        processRequestDto: ProcessRequestDto,
        variables: CreateFullContractInputVariable
    ): CreateFullContractOutputVariable {

        logger.info { "start createFullContract with processRequestDto: $processRequestDto and variables: $variables" }

        val productList: ArrayList<AgreementProductDto> = arrayListOf()

        if (variables.ptpRequiredAssetSingle.isNullOrEmpty() && variables.ptpRequiredAssetDouble.isNullOrEmpty()) throw IllegalAccessException(
            " both 'form_ptp_required_asset_double' and  'form_ptp_required_asset_single' can't be null or empty"
        )

        variables.ptpRequiredAssetDouble?.let {
            variables.ptpRequiredAssetDouble.forEach {
                productList.add(AgreementProductDto(id = it, itemCount = 2, specifications = variables.specifications))
            }
        }

        variables.ptpRequiredAssetSingle?.let {
            variables.ptpRequiredAssetSingle.forEach {
                productList.add(AgreementProductDto(id = it, itemCount = 1, specifications = variables.specifications))
            }
        }
        val contractAgreementDto = ContractAgreementDto(
            timeInterval = "12-MONTH",
            provinceCity = variables.orderProvinceCity,
            postalCode = variables.orderPostalCode,
            geoLocation = variables.geoLocation,
            productList = productList,
            address = variables.orderAddress,
            description = variables.description
        )

        val token = authService.getSystemUserToken()
        logger.info { "createFullContract ---> authService called successfully" }

        logger.info {
            "createFullContract ---> call createFullContract with customerId: ${variables.relationCustomer} and body: " +
                    "$contractAgreementDto"
        }

        val createContractResponse = bssServiceClient.createFullContract(
            customerId = variables.relationCustomer,
            contractAgreementDto = contractAgreementDto,
            token = token
        )

        logger.info { "createFullContract ---> createFullContractResponse: $createContractResponse" }

        logger.info { "end createFullContract with response: $createContractResponse" }

        return CreateFullContractOutputVariable(
            customerId = variables.relationCustomer,
            agreementId = createContractResponse.agreementList[0].id!!,
            relationAgreement = createContractResponse.agreementList[0].id!!
        )
    }
}

data class CreateFullContractInputVariable(
    @JsonProperty("relation_customer") val relationCustomer: String,
    @JsonProperty("form_ptp_required_asset_double") val ptpRequiredAssetDouble: List<String>?,
    @JsonProperty("form_ptp_required_asset_single") val ptpRequiredAssetSingle: List<String>?,
    @JsonProperty("form_order_province_city") val orderProvinceCity: String,
    @JsonProperty("orderPostalCode") val orderPostalCode: String,
    @JsonProperty("form_tech_gps_point") val geoLocation: String,
    @JsonProperty("orderAddress") val orderAddress: String,
    @JsonProperty("description") val description: String,
    @JsonProperty("specifications") val specifications: List<Specification> = arrayListOf()
) : InputVariable


data class CreateFullContractOutputVariable(
    @JsonProperty("customer_id") val customerId: String,
    @JsonProperty("agreement_id") val agreementId: String,
    @JsonProperty("relation_agreement") val relationAgreement: String
) : OutputVariable