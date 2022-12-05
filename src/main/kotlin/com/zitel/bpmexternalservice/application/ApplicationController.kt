package com.zitel.bpmexternalservice.application

import com.zitel.bpmexternalservice.common.ResponseDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${service.api}")
class ApplicationController(
    private val applicationService: ApplicationService
) {

    @PostMapping("execute")
    fun execute(
        @RequestBody req: ApplicationRequestDto,
        @RequestHeader("Authorization") authorization: String
    ): ResponseDto {

        return applicationService.delegateExecution(req.copy(authorization = authorization))
    }
}