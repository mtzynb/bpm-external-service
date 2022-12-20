package com.zitel.bpmexternalservice.client.bss.dto.createfullcontractresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class Number (

  @JsonProperty("value" ) var value : String? = null

)