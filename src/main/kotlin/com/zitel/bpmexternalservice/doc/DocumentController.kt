package com.zitel.bpmexternalservice.doc

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("\${service.api}/docs")
class DocumentController(private val documentService: DocumentService) {

    @GetMapping("services")
    fun services(): List<ServiceDto> {
        return documentService.services()
    }

    @GetMapping("services/{type}")
    fun oneService(@PathVariable type: String): ServiceDto {
        return documentService.oneService(type)
    }
}