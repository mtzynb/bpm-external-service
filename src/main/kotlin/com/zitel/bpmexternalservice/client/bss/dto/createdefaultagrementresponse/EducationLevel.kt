package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class EducationLevel (

  @JsonProperty("@id"          ) var _id          : String?  = null,
  @JsonProperty("key"          ) var key          : String?  = null,
  @JsonProperty("value"        ) var value        : String?  = null,
  @JsonProperty("active"       ) var active       : Boolean? = null,
  @JsonProperty("preDefined"   ) var preDefined   : Boolean? = null,
  @JsonProperty("displayOrder" ) var displayOrder : Int?     = null,
  @JsonProperty("defaultValue" ) var defaultValue : Boolean? = null

)