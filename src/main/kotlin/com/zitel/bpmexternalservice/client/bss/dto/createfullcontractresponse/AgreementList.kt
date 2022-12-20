package com.zitel.bpmexternalservice.client.bss.dto.createfullcontractresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class AgreementList (

  @JsonProperty("@id"               ) var _id               : String?           = null,
  @JsonProperty("id"                ) var id                : String?           = null,
  @JsonProperty("active"            ) var active            : Boolean?          = null,
  @JsonProperty("agreementItemList" ) var agreementItemList : ArrayList<String> = arrayListOf(),
  @JsonProperty("discountList"      ) var discountList      : ArrayList<String> = arrayListOf(),
  @JsonProperty("valid"             ) var valid             : Boolean?          = null

)