package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class ProductType (

  @JsonProperty("key"      ) var key      : String?  = null,
  @JsonProperty("value"    ) var value    : String?  = null,
  @JsonProperty("type"     ) var type     : String?  = null,
  @JsonProperty("billable" ) var billable : Boolean? = null

)