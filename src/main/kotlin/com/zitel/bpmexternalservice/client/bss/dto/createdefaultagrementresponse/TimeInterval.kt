package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class TimeInterval (

  @JsonProperty("timeUnit"   ) var timeUnit   : String? = null,
  @JsonProperty("timeAmount" ) var timeAmount : Int?    = null,
  @JsonProperty("key"        ) var key        : String? = null,
  @JsonProperty("title"      ) var title      : String? = null

)