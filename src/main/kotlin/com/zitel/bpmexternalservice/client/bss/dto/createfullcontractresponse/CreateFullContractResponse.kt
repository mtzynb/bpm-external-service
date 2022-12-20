package com.zitel.bpmexternalservice.client.bss.dto.createfullcontractresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateFullContractResponse (

  @JsonProperty("@id"            ) var _id            : String?                  = null,
  @JsonProperty("id"             ) var id             : String?                  = null,
  @JsonProperty("active"         ) var active         : Boolean?                 = null,
  @JsonProperty("createdBy"      ) var createdBy      : String?                  = null,
  @JsonProperty("resellerId"     ) var resellerId     : String?                  = null,
  @JsonProperty("documentHeader" ) var documentHeader : DocumentHeader?          = DocumentHeader(),
  @JsonProperty("customer"       ) var customer       : Customer?                = Customer(),
  @JsonProperty("agreementList"  ) var agreementList  : ArrayList<AgreementList> = arrayListOf(),
  @JsonProperty("storageFiles"   ) var storageFiles   : ArrayList<String>        = arrayListOf(),
  @JsonProperty("valid"          ) var valid          : Boolean?                 = null

)