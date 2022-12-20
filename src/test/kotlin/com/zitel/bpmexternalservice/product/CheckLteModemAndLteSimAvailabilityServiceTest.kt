package com.zitel.bpmexternalservice.product

import com.zitel.bpmexternalservice.common.ProcessRequestDto
import com.zitel.bpmexternalservice.service.product.*
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CheckLteModemAndLteSimAvailabilityServiceTest {

    private val checkPrInStockService: CheckProductInStockService = mockk(relaxed = true)
    private val checkLteModemAndLteSimAvailabilityService =
        CheckLteModemAndLteSimAvailabilityService(checkPrInStockService)

    @Test
    fun `should check the availability of 2 devices in stock---LTE-MODEM device with IMEI and LTE-SIM device with serial number and return true for both`() {

        //given
        val processRequestDto =
            ProcessRequestDto(id = "123456", authorization = "bearer 6621a723-23b0-4f1f-beb3-b9a023897748")

        val inputVariable = CheckLteModemAndLteSimAvailabilityInputVariable(
            deviceImei = "864262029877744",
            simSerial = "899845000000074117",
            installerUserId = "c2ae28dd-1728-47e9-8337-7b96e08f9b5e",
            lastUser = "e48fece4-edba-416f-a6ca-b1502a261e53"
        )
        every {
            checkPrInStockService.checkProductAvailability(
                processRequestDto = any(),
                variables = any()
            )
        } returns CheckProductInStockOutputVariable(true)


        //when
        val validation_result: CheckLteModemAndLteSimAvailabilityOutputVariable =
            checkLteModemAndLteSimAvailabilityService.execute(
                processRequestDto = processRequestDto,
                variables = inputVariable
            )

        //then
        println("validation_result.imeiValidation =====> $validation_result.imeiValidation")
        println("validation_result.simCardValidation =====> $validation_result.simCardValidation")
        assertEquals(true, validation_result.imeiValidation)
        assertEquals(true, validation_result.simCardValidation)
    }

}