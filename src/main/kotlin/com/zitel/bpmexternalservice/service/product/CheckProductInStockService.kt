package com.zitel.bpmexternalservice.service.product


import com.fasterxml.jackson.annotation.JsonProperty
import com.zitel.bpmexternalservice.client.bss.BssServiceClient
import com.zitel.bpmexternalservice.common.*
import com.zitel.bpmexternalservice.client.auth.AuthService
import com.zitel.bpmexternalservice.client.bss.dto.Characteristic
import com.zitel.bpmexternalservice.client.bss.dto.CharacteristicID
import com.zitel.bpmexternalservice.client.bss.dto.GetEmployeeByUserIdResponse
import com.zitel.bpmexternalservice.client.bss.dto.ProductOfferingResponse
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CheckProductInStockService(
    private val bssServiceClient: BssServiceClient,
    private val authService: AuthService
) : ExecutorService<CheckProductInStockInputVariable, CheckProductInStockOutputVariable>() {

    override val type: String = "check-product-availability"
    override val description: String =
        "This service checks whether a device by its product unique id is available in stock and is valid or not valid"

    val logger = KotlinLogging.logger { }
    override fun execute(
        processRequestDto: ProcessRequestDto, variables: CheckProductInStockInputVariable
    ): CheckProductInStockOutputVariable {
        logger.info { "start execute check-product-availability service for variables: $variables" }
        return checkProductAvailability(processRequestDto = processRequestDto, variables = variables)
    }

    fun checkProductAvailability(
        processRequestDto: ProcessRequestDto,
        variables: CheckProductInStockInputVariable,
    ): CheckProductInStockOutputVariable {


        logger.info { "start checkProductAvailability with processRequestDto: $processRequestDto and variables: $variables" }

        val productOfferingResponse: ProductOfferingResponse = bssServiceClient.getProductOfferingOrderById(
            productOfferingId = variables.productCode, //TODO : use another service to give a real product code instead of product id
            token = processRequestDto.authorization
        )
        logger.info { "checkProductAvailability ---> productOfferingResponse: $productOfferingResponse" }

        var characteristicId: String = ""

        productOfferingResponse.product.characteristicList.forEach {
            if (it.key.equals(variables.characteristicKey, true))
                characteristicId = it.id
        }

        if (variables.lastUser != "1") variables.installerUserId = variables.lastUser

        val employee: GetEmployeeByUserIdResponse = bssServiceClient.getEmployeeByUserId(
            userId = variables.installerUserId,
            token = processRequestDto.authorization
        )

        logger.info { "checkProductAvailability ---> employee: $employee" }

        val token = authService.getSystemUserToken()
        logger.info { "checkProductAvailability ---> authService called successfully" }

        val validationResponse: Boolean = bssServiceClient.checkEmployeeStock(
            productOfferingId = productOfferingResponse.id,
            employeeId = employee.id,
            listOf(
                Characteristic(
                    selectedValue = variables.productUniqueId,
                    selectedValueLabel = variables.productUniqueId,
                    key = variables.characteristicKey,
                    keyLabel = variables.characteristicLabel,
                    characteristicID = CharacteristicID(id = characteristicId),
                    monolingual = true,
                    sortOrder = 0
                )
            ), token = token
        )

        logger.info { "checkProductAvailability ---> validationResponse: $validationResponse" }

        logger.info { "end checkProductAvailability with availability status: $validationResponse" }

        return CheckProductInStockOutputVariable(validationResponse)
    }

}


data class CheckProductInStockInputVariable(
    @JsonProperty("product_code") val productCode: String,
    @JsonProperty("product_unique_id") val productUniqueId: String,
    @JsonProperty("characteristic_key") val characteristicKey: String,
    @JsonProperty("characteristic_label") val characteristicLabel: String,
    @JsonProperty("form_installer_user_id") var installerUserId: String,
    @JsonProperty("last_user") val lastUser: String
) : InputVariable


data class CheckProductInStockOutputVariable(@JsonProperty("validation_result") var validationResult: Boolean = false) :
    OutputVariable