package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty



data class MediumList (

  @JsonProperty("@id"           ) var _id           : String?  = null,
  @JsonProperty("id"            ) var id            : String?  = null,
  @JsonProperty("active"        ) var active        : Boolean? = null,
  @JsonProperty("createTime"    ) var createTime    : Int?     = null,
  @JsonProperty("createdBy"     ) var createdBy     : String?  = null,
  @JsonProperty("resellerId"    ) var resellerId    : String?  = null,
  @JsonProperty("mediumType"    ) var mediumType    : String?  = null,
  @JsonProperty("value"         ) var value         : String?  = null,
  @JsonProperty("defaultInType" ) var defaultInType : Boolean? = null,
  @JsonProperty("party"         ) var party         : Party?   = Party(),
  @JsonProperty("valid"         ) var valid         : Boolean? = null

)