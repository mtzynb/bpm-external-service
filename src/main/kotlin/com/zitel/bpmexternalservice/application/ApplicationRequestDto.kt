package com.zitel.bpmexternalservice.application

import com.zitel.bpmexternalservice.common.ProcessRequestDto

data class ApplicationRequestDto(
    val type: String,
    val processId: String,
    val variables: Map<String, Any>,
    override val authorization: String = ""
) : ProcessRequestDto(id = processId, authorization)