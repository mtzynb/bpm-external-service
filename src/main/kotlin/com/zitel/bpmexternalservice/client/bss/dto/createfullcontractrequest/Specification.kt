package com.zitel.bpmexternalservice.client.bss.dto.createfullcontractrequest

import com.fasterxml.jackson.annotation.JsonProperty

data class Specification (

  @JsonProperty("selectedValue"      ) var selectedValue      : String? = null,
  @JsonProperty("selectedValueLabel" ) var selectedValueLabel : String? = null,
  @JsonProperty("key"                ) var key                : String? = null,
  @JsonProperty("keyLabel"           ) var keyLabel           : String? = null

)