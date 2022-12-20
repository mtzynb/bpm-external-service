package com.zitel.bpmexternalservice.product

import com.zitel.bpmexternalservice.client.bss.BssServiceClient
import com.zitel.bpmexternalservice.common.ProcessRequestDto
import com.zitel.bpmexternalservice.client.auth.AuthService
import com.zitel.bpmexternalservice.service.product.CheckProductInStockInputVariable
import com.zitel.bpmexternalservice.service.product.CheckProductInStockOutputVariable
import com.zitel.bpmexternalservice.service.product.CheckProductInStockService
import io.mockk.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckProductInStockServiceTest {

    private val authService: AuthService = mockk(relaxed = true)
    private val bssServiceClient: BssServiceClient = mockk(relaxed = true)
    private val checkProductInStockService = CheckProductInStockService(bssServiceClient, authService)

    @Test
    fun `should check availability of LTE-MODEM device with IMEI and return true`() {
        //given

        val processRequestDto =
            ProcessRequestDto(id = "123456", authorization = "bearer 6621a723-23b0-4f1f-beb3-b9a023897748")

        val inputVariable = CheckProductInStockInputVariable(
            productCode = "48d5fed8-8337-46df-929b-f0ff1acdfdef",
            productUniqueId = "864262029877744",
            characteristicKey = "imei",
            characteristicLabel = "IMEI",
            installerUserId = "c2ae28dd-1728-47e9-8337-7b96e08f9b5e",
            lastUser = "e48fece4-edba-416f-a6ca-b1502a261e53"
        )

        every {
            bssServiceClient.checkEmployeeStock(
                productOfferingId = any(),
                employeeId = any(),
                characteristicList = any(),
                token = any()
            )
        } returns true

        //when

        val validationResult: CheckProductInStockOutputVariable =
            checkProductInStockService.execute(processRequestDto = processRequestDto, variables = inputVariable)

        //then
        println("validation_result.imeiValidation =====> $validationResult")
        assertEquals(true, validationResult.validationResult)

    }

    @Test
    fun `should check availability of LTE-SIM device with serial number and return true`() {
        //given

        val processRequestDto =
            ProcessRequestDto(id = "123456", authorization = "bearer 6621a723-23b0-4f1f-beb3-b9a023897748")

        val inputVariable = CheckProductInStockInputVariable(
            productCode = "a85bc3d3-38a8-42e1-86b7-e8879ad1af14",
            productUniqueId = "899845000000074117",
            characteristicKey = "serial_number",
            characteristicLabel = "شماره سریال",
            installerUserId = "c2ae28dd-1728-47e9-8337-7b96e08f9b5e",
            lastUser = "e48fece4-edba-416f-a6ca-b1502a261e53"
        )

        every {
            bssServiceClient.checkEmployeeStock(
                productOfferingId = any(),
                employeeId = any(),
                characteristicList = any(),
                token = any()
            )
        } returns true

        //when

        val validationResult: CheckProductInStockOutputVariable =
            checkProductInStockService.execute(processRequestDto = processRequestDto, variables = inputVariable)

        //then
        println("validation_result.imeiValidation =====> $validationResult")
        assertEquals(true, validationResult.validationResult)

    }

}