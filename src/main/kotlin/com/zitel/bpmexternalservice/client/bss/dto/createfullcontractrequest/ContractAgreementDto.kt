package com.zitel.bpmexternalservice.client.bss.dto.createfullcontractrequest

import com.fasterxml.jackson.annotation.JsonProperty


data class ContractAgreementDto (

  @JsonProperty("timeInterval" ) var timeInterval : String?                = null, 
  @JsonProperty("provinceCity" ) var provinceCity : String?                = null, 
  @JsonProperty("postalCode"   ) var postalCode   : String?                = null, 
  @JsonProperty("geoLocation"  ) var geoLocation  : String?                = null, 
  @JsonProperty("productList"  ) var productList  : ArrayList<AgreementProductDto>? = arrayListOf(),
  @JsonProperty("address"      ) var address      : String?                = null,
  @JsonProperty("description"  ) var description  : String?                = null

)
