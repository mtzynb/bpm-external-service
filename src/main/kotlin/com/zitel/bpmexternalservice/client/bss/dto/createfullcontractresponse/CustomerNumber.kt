package com.zitel.bpmexternalservice.client.bss.dto.createfullcontractresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class CustomerNumber (

  @JsonProperty("value" ) var value : String? = null

)