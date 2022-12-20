package com.zitel.bpmexternalservice.service.contract

import com.zitel.bpmexternalservice.client.auth.AuthService
import com.zitel.bpmexternalservice.client.bss.BssServiceClient
import com.zitel.bpmexternalservice.client.bss.dto.createfullcontractrequest.Specification
import com.zitel.bpmexternalservice.client.bss.dto.createfullcontractresponse.AgreementList
import com.zitel.bpmexternalservice.client.bss.dto.createfullcontractresponse.CreateFullContractResponse
import com.zitel.bpmexternalservice.common.ProcessRequestDto
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CreateFullContractServiceTest {


    private val authService: AuthService = mockk(relaxed = true)
    private val bssServiceClient: BssServiceClient = mockk(relaxed = true)
    private val createFullContractService = CreateFullContractService(bssServiceClient, authService)

    @Test
    fun `should give customer order and create a successful full contract `() {

        //given
        val processRequestDto =
            ProcessRequestDto(id = "123456", authorization = "bearer 6621a723-23b0-4f1f-beb3-b9a023897748")

        val inputVariable = CreateFullContractInputVariable(
            relationCustomer = "4641f209-2084-48d1-9b8d-4812ca6a2ed4",
            ptpRequiredAssetDouble = listOf(
                "48d5fed8-8337-46df-929b-f0ff1acdfdef",
                "a85bc3d3-38a8-42e1-86b7-e8879ad1af14"
            ),
            ptpRequiredAssetSingle = listOf(
                "48d5fed8-8337-46df-929b-f0ff1acdfdef",
                "a85bc3d3-38a8-42e1-86b7-e8879ad1af14"
            ),
            orderProvinceCity = "آذربایجان شرقی_تیمورلو",
            orderPostalCode = "1313131313",
            geoLocation = "35.69362249260061,51.34906766916423",
            orderAddress = "آدرس سفارش نابیابتایعباعقا",
            description = "",
            specifications = listOf(Specification("864262029877744", "864262029877744", "imei", "IMEI"))
        )

        every {
            bssServiceClient.createFullContract(any(), any(), any())
        } returns CreateFullContractResponse(agreementList = arrayListOf(AgreementList(id = "7f10b98a-2f49-495e-9fde-e189cd6e31c0")))


        //when
        val createFullContractValue: CreateFullContractOutputVariable =
            createFullContractService.execute(processRequestDto = processRequestDto, variables = inputVariable)

        //then
        println("createFullContractValue =====> $createFullContractValue")
        assertEquals("4641f209-2084-48d1-9b8d-4812ca6a2ed4", createFullContractValue.customerId)
        assertEquals("7f10b98a-2f49-495e-9fde-e189cd6e31c0", createFullContractValue.agreementId)
        assertEquals("7f10b98a-2f49-495e-9fde-e189cd6e31c0", createFullContractValue.relationAgreement)

    }

}
