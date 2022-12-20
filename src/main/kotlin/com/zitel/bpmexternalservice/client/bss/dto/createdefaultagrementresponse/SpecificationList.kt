package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class SpecificationList (

  @JsonProperty("active"             ) var active             : Boolean? = null,
  @JsonProperty("characteristicId"   ) var characteristicId   : String?  = null,
  @JsonProperty("key"                ) var key                : String?  = null,
  @JsonProperty("keyLabel"           ) var keyLabel           : String?  = null,
  @JsonProperty("selectedValue"      ) var selectedValue      : String?  = null,
  @JsonProperty("selectedValueLabel" ) var selectedValueLabel : String?  = null,
  @JsonProperty("monolingual"        ) var monolingual        : Boolean? = null,
  @JsonProperty("sortOrder"          ) var sortOrder          : Int?     = null,
  @JsonProperty("parentRefId"        ) var parentRefId        : String?  = null

)