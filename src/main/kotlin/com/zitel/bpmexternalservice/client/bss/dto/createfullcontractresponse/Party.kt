package com.zitel.bpmexternalservice.client.bss.dto.createfullcontractresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class Party (

  @JsonProperty("@id"            ) var _id            : String?           = null,
  @JsonProperty("id"             ) var id             : String?           = null,
  @JsonProperty("active"         ) var active         : Boolean?          = null,
  @JsonProperty("identification" ) var identification : Identification?   = Identification(),
  @JsonProperty("fullName"       ) var fullName       : String?           = null,
  @JsonProperty("mediumList"     ) var mediumList     : ArrayList<String> = arrayListOf(),
  @JsonProperty("editable"       ) var editable       : Boolean?          = null,
  @JsonProperty("valid"          ) var valid          : Boolean?          = null

)