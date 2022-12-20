package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class Identification (

  @JsonProperty("value"              ) var value              : String? = null,
  @JsonProperty("identificationType" ) var identificationType : String? = null

)