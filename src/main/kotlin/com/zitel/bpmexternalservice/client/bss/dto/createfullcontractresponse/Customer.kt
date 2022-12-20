package com.zitel.bpmexternalservice.client.bss.dto.createfullcontractresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class Customer (

  @JsonProperty("@id"            ) var _id            : String?         = null,
  @JsonProperty("id"             ) var id             : String?         = null,
  @JsonProperty("active"         ) var active         : Boolean?        = null,
  @JsonProperty("party"          ) var party          : Party?          = Party(),
  @JsonProperty("customerNumber" ) var customerNumber : CustomerNumber? = CustomerNumber(),
  @JsonProperty("initialBalance" ) var initialBalance : Int?            = null,
  @JsonProperty("valid"          ) var valid          : Boolean?        = null

)