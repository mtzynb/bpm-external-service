package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class Product (

  @JsonProperty("@id"                ) var _id                : String?                       = null,
  @JsonProperty("id"                 ) var id                 : String?                       = null,
  @JsonProperty("active"             ) var active             : Boolean?                      = null,
  @JsonProperty("createTime"         ) var createTime         : Int?                          = null,
  @JsonProperty("createdBy"          ) var createdBy          : String?                       = null,
  @JsonProperty("resellerId"         ) var resellerId         : String?                       = null,
  @JsonProperty("productDefinition"  ) var productDefinition  : ProductDefinition?            = ProductDefinition(),
  @JsonProperty("category"           ) var category           : String?                       = null,
  @JsonProperty("code"               ) var code               : String?                       = null,
  @JsonProperty("name"               ) var name               : String?                       = null,
  @JsonProperty("bundle"             ) var bundle             : Boolean?                      = null,
  @JsonProperty("countable"          ) var countable          : Boolean?                      = null,
  @JsonProperty("characteristicList" ) var characteristicList : ArrayList<CharacteristicList> = arrayListOf(),
  @JsonProperty("valid"              ) var valid              : Boolean?                      = null

)