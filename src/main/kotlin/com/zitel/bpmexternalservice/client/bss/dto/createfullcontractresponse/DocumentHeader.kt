package com.zitel.bpmexternalservice.client.bss.dto.createfullcontractresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class DocumentHeader (

  @JsonProperty("number" ) var number : Number? = Number(),
  @JsonProperty("date"   ) var date   : Int?    = null,
  @JsonProperty("status" ) var status : Status? = Status()

)