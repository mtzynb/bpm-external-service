package com.zitel.bpmexternalservice.doc

import com.zitel.bpmexternalservice.application.ApplicationService
import org.springframework.stereotype.Service

@Service
class DocumentService(private val applicationService: ApplicationService) {

    fun services(): List<ServiceDto> =
        applicationService.executorServices().entries.map {
            ServiceDto(
                it.value.type,
                it.value.description
            )
        }

    fun oneService(type: String): ServiceDto {
        val executorService = applicationService.findExecutorService(type)

        return ServiceDto(
            executorService.type,
            executorService.description,
            executorService.inputClass,
            executorService.outputClass
        )
    }
}