package com.zitel.bpmexternalservice.service.aggrement

import com.zitel.bpmexternalservice.client.auth.AuthService
import com.zitel.bpmexternalservice.client.bss.BssServiceClient
import com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse.AgreementItemList
import com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse.CreateDefaultAgreementResponse
import com.zitel.bpmexternalservice.common.ProcessRequestDto
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CreateDefaultAgreementServiceTest {

    private val authService: AuthService = mockk(relaxed = true)
    private val bssServiceClient: BssServiceClient = mockk(relaxed = true)
    private val createDefaultAgreementService: CreateDefaultAgreementService =
        CreateDefaultAgreementService(bssServiceClient, authService)


    @Test
    fun `should give a customer and order id with service_category = "ZITEL_FIBER" and create a default agreement successfully`() {
        //given
        val processRequestDto =
            ProcessRequestDto(id = "123456", authorization = "bearer 6621a723-23b0-4f1f-beb3-b9a023897748")

        val inputVariable = CreateDefaultAgreementInputVariable(
            customerId = "32297c50-1738-4a28-a4f8-9e51b6ea3efe",
            purchaseOrderIid = "44998012-08de-49a0-97f8-80bfe70f0652",
            serviceCategory = "ZITEL_FIBER"
        )

        every {
            bssServiceClient.createDefaultAgreement(
                customerId = any(),
                orderId = any(),
                defaultAgreementDto = any(),
                token = any()
            )
        } returns CreateDefaultAgreementResponse(
            id = "556670d6-da62-43b9-8d41-2fda88f670e5",
            agreementItemList = arrayListOf(AgreementItemList(id = "54ec71a1-22ec-40fb-91d5-b0b16ff51ab8"))
        )

        //when

        val createDefaultAgreementValue: CreateDefaultAgreementOutputVariable =
            createDefaultAgreementService.execute(processRequestDto = processRequestDto, variables = inputVariable)

        //then
        println("createDefaultAgreementValue =====> $createDefaultAgreementValue")
        assertEquals("556670d6-da62-43b9-8d41-2fda88f670e5", createDefaultAgreementValue.relationAgreement)
        assertEquals("54ec71a1-22ec-40fb-91d5-b0b16ff51ab8", createDefaultAgreementValue.agreementItemId)
    }


    @Test
    fun `should give a customer and order id with service_category = "" and create a default agreement successfully`() {
        //given
        val processRequestDto =
            ProcessRequestDto(id = "123456", authorization = "bearer 6621a723-23b0-4f1f-beb3-b9a023897748")

        val inputVariable = CreateDefaultAgreementInputVariable(
            customerId = "32297c50-1738-4a28-a4f8-9e51b6ea3efe",
            purchaseOrderIid = "44998012-08de-49a0-97f8-80bfe70f0652",
            serviceCategory = ""
        )

        every {
            bssServiceClient.createDefaultAgreement(
                customerId = any(),
                orderId = any(),
                defaultAgreementDto = any(),
                token = any()
            )
        } returns CreateDefaultAgreementResponse(
            id = "60140e06-f2fd-4f16-ad60-194d5dc3a885",
            agreementItemList = arrayListOf(AgreementItemList(id = "8bd4b000-1c5b-4ca7-a297-983dd681eaee"))
        )

        //when

        val createDefaultAgreementValue: CreateDefaultAgreementOutputVariable =
            createDefaultAgreementService.execute(processRequestDto = processRequestDto, variables = inputVariable)

        //then
        println("createDefaultAgreementValue =====> $createDefaultAgreementValue")
        assertEquals("60140e06-f2fd-4f16-ad60-194d5dc3a885", createDefaultAgreementValue.relationAgreement)
        assertEquals("8bd4b000-1c5b-4ca7-a297-983dd681eaee", createDefaultAgreementValue.agreementItemId)

    }

}