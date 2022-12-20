package com.zitel.bpmexternalservice.client.bss

import com.zitel.bpmexternalservice.client.bss.dto.Characteristic
import com.zitel.bpmexternalservice.client.bss.dto.GetEmployeeByUserIdResponse
import com.zitel.bpmexternalservice.client.bss.dto.ProductOfferingResponse
import com.zitel.bpmexternalservice.client.bss.dto.createfullcontractresponse.CreateFullContractResponse
import com.zitel.bpmexternalservice.client.bss.dto.createfullcontractrequest.ContractAgreementDto
import com.zitel.bpmexternalservice.client.bss.dto.createdefaultagreementrequest.DefaultAgreementDto
import com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse.CreateDefaultAgreementResponse
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PostExchange

@HttpExchange("/bss-service/api")
interface BssServiceClient {

    @GetExchange("/product-offerings/{id}")
    fun getProductOfferingOrderById(
        @PathVariable("id") productOfferingId: String,
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String
    ): ProductOfferingResponse


    @GetExchange("/employees/find-by-user")
    fun getEmployeeByUserId(
        @RequestParam("user-id") userId: String,
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String
    ): GetEmployeeByUserIdResponse


    @PostExchange("/warehouses/check-employee-stock?channel=mobile_app")
    fun checkEmployeeStock(
        @RequestParam("offering-id") productOfferingId: String,
        @RequestParam("employee-id") employeeId: String,
        @RequestBody characteristicList: List<Characteristic>,
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String
    ): Boolean


    @PostExchange("/contracts/full")
    fun createFullContract(
        @RequestParam("customer") customerId: String,
        @RequestBody contractAgreementDto: ContractAgreementDto,
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String
    ): CreateFullContractResponse

    @PostExchange("/agreements/default")
    fun createDefaultAgreement(
        @RequestParam("customer") customerId: String,
        @RequestParam("order") orderId: String,
        @RequestBody defaultAgreementDto: DefaultAgreementDto,
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String
    ): CreateDefaultAgreementResponse

}