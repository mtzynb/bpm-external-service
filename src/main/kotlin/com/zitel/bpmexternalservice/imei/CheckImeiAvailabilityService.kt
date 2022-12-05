package com.zitel.bpmexternalservice.imei

import GetEmployeeByUserIdResponse
import com.fasterxml.jackson.annotation.JsonProperty
import com.zitel.bpmexternalservice.common.*
import com.zitel.bpmexternalservice.common.auth.AuthService
import com.zitel.bpmexternalservice.common.dto.Characteristic
import com.zitel.bpmexternalservice.common.dto.ProductOfferingResponse
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CheckImeiAvailabilityService(
    private val bssServiceClient: BssServiceClient,
    private val authService: AuthService
) :
    ExecutorService<CheckImeiAvailabilityInputVariable, CheckImeiAvailabilityOutputVariable>() {

    override val type: String = "check-imei-availability"
    override val description: String = "This service checks whether a device IMEI is valid or not valid"

    val logger = KotlinLogging.logger { }

    override fun execute(
        processRequestDto: ProcessRequestDto,
        variables: CheckImeiAvailabilityInputVariable
    ): CheckImeiAvailabilityOutputVariable {

        val token = authService.getSystemUserToken()

        val productOfferingRes: ProductOfferingResponse = bssServiceClient.getProductOfferingOrderById(
            productOfferingId = "48d5fed8-8337-46df-929b-f0ff1acdfdef",
            systemToken = token
        )

        val characteristic = Characteristic(
            selectedValue = variables.formEquipmentDeviceImei1,
            selectedValueLabel = variables.formEquipmentDeviceImei1,
            key = "imei",
            keyLabel = "IMEI",
            characteristicId = null,
            monolingual = "true",
            sortOrder = "0"
        )

        productOfferingRes.product.characteristicList.forEach {
            if (it.key.equals("imei", true))
                characteristic.copy(characteristicId = "{\"id\" : \"${it.id}\"}")
        }

        if (variables.lastUser != "1") {
            variables.formInstallerUserId = variables.lastUser
        }

        val getEmployeeByUserIdResponse: GetEmployeeByUserIdResponse = bssServiceClient.getEmployeeByUserId(
            userId = variables.formInstallerUserId,
            systemToken = token
        )

        val validationResponse: Boolean = bssServiceClient.checkEmployeeStock(
            productOfferingId = productOfferingRes.id,
            employeeId = getEmployeeByUserIdResponse.id,
            listOf(characteristic),
            systemToken = token
        )

        return CheckImeiAvailabilityOutputVariable(validationResponse, variables.formInstallerUserId)
    }
}


data class CheckImeiAvailabilityInputVariable(
    @JsonProperty("form_equipment_device_imei_1") val formEquipmentDeviceImei1: String,
    @JsonProperty("form_installer_user_id") var formInstallerUserId: String,
    @JsonProperty("last_user") val lastUser: String,
) : InputVariable


data class CheckImeiAvailabilityOutputVariable(
    @JsonProperty("imei_validation") val imeiValidation: Boolean = false,
    @JsonProperty("form_installer_user_id") val formInstallerUserId: String,
) : OutputVariable
