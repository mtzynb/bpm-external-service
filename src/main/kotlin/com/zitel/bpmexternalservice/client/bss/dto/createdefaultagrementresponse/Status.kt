package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class Status (

  @JsonProperty("key"                            ) var key                            : String?                                   = null,
  @JsonProperty("value"                          ) var value                          : String?                                   = null,
  @JsonProperty("documentType"                   ) var documentType                   : String?                                   = null,
  @JsonProperty("dealType"                       ) var dealType                       : String?                                   = null,
  @JsonProperty("statusType"                     ) var statusType                     : String?                                   = null,
  @JsonProperty("allowedDocumentTransactionList" ) var allowedDocumentTransactionList : ArrayList<AllowedDocumentTransactionList> = arrayListOf(),
  @JsonProperty("active"                         ) var active                         : Boolean?                                  = null

)