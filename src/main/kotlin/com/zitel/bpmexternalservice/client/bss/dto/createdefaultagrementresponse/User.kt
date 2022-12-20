package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class User (

  @JsonProperty("id"       ) var id       : String?  = null,
  @JsonProperty("username" ) var username : String?  = null,
  @JsonProperty("password" ) var password : String?  = null,
  @JsonProperty("online"   ) var online   : Boolean? = null

)