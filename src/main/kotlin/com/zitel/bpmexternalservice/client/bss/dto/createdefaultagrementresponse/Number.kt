package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class Number (

  @JsonProperty("value"        ) var value        : String? = null,
  @JsonProperty("documentType" ) var documentType : String? = null

)