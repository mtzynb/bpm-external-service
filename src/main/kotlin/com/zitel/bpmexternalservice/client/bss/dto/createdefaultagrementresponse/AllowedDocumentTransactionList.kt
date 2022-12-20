package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class AllowedDocumentTransactionList (

  @JsonProperty("key"             ) var key             : String?  = null,
  @JsonProperty("value"           ) var value           : String?  = null,
  @JsonProperty("documentType"    ) var documentType    : String?  = null,
  @JsonProperty("transactionType" ) var transactionType : String?  = null,
  @JsonProperty("statusType"      ) var statusType      : String?  = null,
  @JsonProperty("active"          ) var active          : Boolean? = null

)