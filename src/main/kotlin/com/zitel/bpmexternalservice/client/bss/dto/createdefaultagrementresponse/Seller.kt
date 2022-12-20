package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class Seller (

  @JsonProperty("@id"              ) var _id              : String?  = null,
  @JsonProperty("id"               ) var id               : String?  = null,
  @JsonProperty("active"           ) var active           : Boolean? = null,
  @JsonProperty("createTime"       ) var createTime       : Int?     = null,
  @JsonProperty("createdBy"        ) var createdBy        : String?  = null,
  @JsonProperty("resellerId"       ) var resellerId       : String?  = null,
  @JsonProperty("name"             ) var name             : String?  = null,
  @JsonProperty("number"           ) var number           : Number?  = Number(),
  @JsonProperty("status"           ) var status           : Status?  = Status(),
  @JsonProperty("mainSeller"       ) var mainSeller       : Boolean? = null,
  @JsonProperty("parentResellerId" ) var parentResellerId : String?  = null,
  @JsonProperty("valid"            ) var valid            : Boolean? = null

)