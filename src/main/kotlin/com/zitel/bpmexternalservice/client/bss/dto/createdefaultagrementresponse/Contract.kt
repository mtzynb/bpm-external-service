package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty



data class Contract (

  @JsonProperty("@id"            ) var _id            : String?         = null,
  @JsonProperty("id"             ) var id             : String?         = null,
  @JsonProperty("active"         ) var active         : Boolean?        = null,
  @JsonProperty("createTime"     ) var createTime     : Int?            = null,
  @JsonProperty("createdBy"      ) var createdBy      : String?         = null,
  @JsonProperty("resellerId"     ) var resellerId     : String?         = null,
  @JsonProperty("documentType"   ) var documentType   : String?         = null,
  @JsonProperty("documentHeader" ) var documentHeader : DocumentHeader? = DocumentHeader(),
  @JsonProperty("customer"       ) var customer       : Customer?       = Customer(),
  @JsonProperty("seller"         ) var seller         : Seller?         = Seller(),
  @JsonProperty("finalCustomer"  ) var finalCustomer  : Boolean?        = null,
  @JsonProperty("valid"          ) var valid          : Boolean?        = null

)