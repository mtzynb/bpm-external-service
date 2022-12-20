package com.zitel.bpmexternalservice.service.product

import com.fasterxml.jackson.annotation.JsonProperty
import com.zitel.bpmexternalservice.common.*
import mu.KotlinLogging

import org.springframework.stereotype.Service

@Service
class CheckLteModemAndLteSimAvailabilityService(
    private val checkProductInStockService: CheckProductInStockService
) : ExecutorService<CheckLteModemAndLteSimAvailabilityInputVariable, CheckLteModemAndLteSimAvailabilityOutputVariable>() {

    override val type: String = "check-lte-modem-availability-and-check-lte-sim-availability"

    override val description: String = buildString {
        append("This service checks availability of two devices in stock,")
        append("1-  lte-modem device by its IMEI is valid or not valid")
        append("2-  lte-sim device serial number is valid or not valid")
    }

    val logger = KotlinLogging.logger { }

    override fun execute(
        processRequestDto: ProcessRequestDto,
        variables: CheckLteModemAndLteSimAvailabilityInputVariable
    ): CheckLteModemAndLteSimAvailabilityOutputVariable {

        logger.info { "start execute check-lte-modem-availability-and-check-lte-sim-availability service for variables: $variables" }


        var lteModemValidationResult = CheckProductInStockOutputVariable()
        var lteSimValidationResult = CheckProductInStockOutputVariable()

        if (variables.deviceImei != null) {
            logger.info { "start call checkProductAvailability for LTE-Modem" }

            lteModemValidationResult = checkProductInStockService.checkProductAvailability(
                processRequestDto,
                CheckProductInStockInputVariable(
                    productCode = "48d5fed8-8337-46df-929b-f0ff1acdfdef",
                    productUniqueId = variables.deviceImei,
                    characteristicKey = "imei",
                    characteristicLabel = "IMEI",
                    installerUserId = variables.installerUserId,
                    lastUser = variables.lastUser
                )
            )
            logger.info { "end call checkProductAvailability for LTE-Modem with validation result: $lteModemValidationResult" }

        }
        if (variables.simSerial != null) {

            logger.info { "start call checkProductAvailability for LTE-SIM" }

            lteSimValidationResult = checkProductInStockService.checkProductAvailability(
                processRequestDto,
                CheckProductInStockInputVariable(
                    productCode = "a85bc3d3-38a8-42e1-86b7-e8879ad1af14",
                    productUniqueId = variables.simSerial,
                    characteristicKey = "serial_number",
                    characteristicLabel = "شماره سریال",
                    installerUserId = variables.installerUserId,
                    lastUser = variables.lastUser
                )
            )
            logger.info { "end call checkProductAvailability for LTE-SIM with validation result: $lteSimValidationResult" }
        }

        return CheckLteModemAndLteSimAvailabilityOutputVariable(
            lteModemValidationResult.validationResult,
            lteSimValidationResult.validationResult
        )
    }

}


data class CheckLteModemAndLteSimAvailabilityInputVariable(
    @JsonProperty("form_equipment_device_imei_1") val deviceImei: String?,
    @JsonProperty("form_equipment_sim_serial_1") val simSerial: String?,
    @JsonProperty("form_installer_user_id") var installerUserId: String,
    @JsonProperty("last_user") val lastUser: String,
) : InputVariable


data class CheckLteModemAndLteSimAvailabilityOutputVariable(
    @JsonProperty("imei_validation") val imeiValidation: Boolean = false,
    @JsonProperty("simcard_validation") val simCardValidation: Boolean = false,
) : OutputVariable
