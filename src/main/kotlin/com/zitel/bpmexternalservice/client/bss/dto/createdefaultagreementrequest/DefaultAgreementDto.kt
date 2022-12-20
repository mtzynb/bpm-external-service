package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagreementrequest

import com.fasterxml.jackson.annotation.JsonProperty

data class DefaultAgreementDto(
    @JsonProperty("description"               ) var description               : String?           = null
)
