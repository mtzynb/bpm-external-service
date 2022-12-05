package com.zitel.bpmexternalservice.common

import GetEmployeeByUserIdResponse
import com.zitel.bpmexternalservice.common.dto.Characteristic
import com.zitel.bpmexternalservice.common.dto.ProductOfferingResponse
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PostExchange

@HttpExchange("bss-service/api")
interface BssServiceClient {

    @GetExchange("/product-offerings/{id}")
    fun getProductOfferingOrderById(
        @PathVariable("id") productOfferingId: String,
        @RequestHeader(HttpHeaders.AUTHORIZATION) systemToken: String
    ): ProductOfferingResponse


    @GetExchange("/employees/find-by-user")
    fun getEmployeeByUserId(
        @RequestParam("user-id") userId: String,
        @RequestHeader(HttpHeaders.AUTHORIZATION) systemToken: String
    ): GetEmployeeByUserIdResponse


    @PostExchange("/warehouses/check-employee-stock?channel=mobile_app")
    fun checkEmployeeStock(
        @RequestParam("offering-id") productOfferingId: String,
        @RequestParam("employee-id") employeeId: String,
        @RequestBody req: List<Characteristic>,
        @RequestHeader(HttpHeaders.AUTHORIZATION) systemToken: String
    ): Boolean


}