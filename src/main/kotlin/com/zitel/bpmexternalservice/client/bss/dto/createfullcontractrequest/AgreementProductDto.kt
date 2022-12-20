package com.zitel.bpmexternalservice.client.bss.dto.createfullcontractrequest

import com.fasterxml.jackson.annotation.JsonProperty


data class AgreementProductDto(

  @JsonProperty("id"             ) var id: String?                   = null,
  @JsonProperty("itemCount"      ) var itemCount: Int?                      = null,
  @JsonProperty("specifications" ) var specifications: List<Specification>? = arrayListOf()

)

