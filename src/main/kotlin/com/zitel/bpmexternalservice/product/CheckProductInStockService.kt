package com.zitel.bpmexternalservice.product

import com.fasterxml.jackson.annotation.JsonProperty
import com.zitel.bpmexternalservice.common.BssServiceClient
import com.zitel.bpmexternalservice.common.InputVariable
import com.zitel.bpmexternalservice.common.OutputVariable
import com.zitel.bpmexternalservice.common.auth.AuthService

class CheckProductInStockService(private val bssServiceClient: BssServiceClient, private val authService: AuthService) {


}



data class CheckProductInStockServiceInputVariable(
    @JsonProperty("product") val formEquipmentDeviceImei1: String,
    @JsonProperty("last_user") val lastUser: String
) : InputVariable


data class CheckProductInStockServiceOutputVariable(@JsonProperty("imei_validation") val imeiValidation: String) :
    OutputVariable