package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class CipLevel (

  @JsonProperty("@id"            ) var _id            : String?  = null,
  @JsonProperty("id"             ) var id             : String?  = null,
  @JsonProperty("active"         ) var active         : Boolean? = null,
  @JsonProperty("createTime"     ) var createTime     : Int?     = null,
  @JsonProperty("createdBy"      ) var createdBy      : String?  = null,
  @JsonProperty("resellerId"     ) var resellerId     : String?  = null,
  @JsonProperty("cipLevelName"   ) var cipLevelName   : String?  = null,
  @JsonProperty("permittedDebit" ) var permittedDebit : Int?     = null,
  @JsonProperty("gatewaySettle"  ) var gatewaySettle  : Boolean? = null,
  @JsonProperty("cipOrder"       ) var cipOrder       : Int?     = null,
  @JsonProperty("cipColor"       ) var cipColor       : String?  = null,
  @JsonProperty("defaultLevel"   ) var defaultLevel   : Boolean? = null,
  @JsonProperty("valid"          ) var valid          : Boolean? = null

)