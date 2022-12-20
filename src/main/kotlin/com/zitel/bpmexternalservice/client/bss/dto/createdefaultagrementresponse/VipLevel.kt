package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class VipLevel (

  @JsonProperty("@id"                  ) var _id                  : String?  = null,
  @JsonProperty("id"                   ) var id                   : String?  = null,
  @JsonProperty("active"               ) var active               : Boolean? = null,
  @JsonProperty("createTime"           ) var createTime           : Int?     = null,
  @JsonProperty("createdBy"            ) var createdBy            : String?  = null,
  @JsonProperty("resellerId"           ) var resellerId           : String?  = null,
  @JsonProperty("vipLevelKey"          ) var vipLevelKey          : String?  = null,
  @JsonProperty("vipLevelName"         ) var vipLevelName         : String?  = null,
  @JsonProperty("virtualCreditAmount"  ) var virtualCreditAmount  : Int?     = null,
  @JsonProperty("virtualCreditPercent" ) var virtualCreditPercent : Int?     = null,
  @JsonProperty("currency"             ) var currency             : String?  = null,
  @JsonProperty("valid"                ) var valid                : Boolean? = null

)