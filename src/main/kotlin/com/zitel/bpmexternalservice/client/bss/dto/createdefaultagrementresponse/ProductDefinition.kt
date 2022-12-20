package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductDefinition (

  @JsonProperty("@id"                   ) var _id                   : String?                          = null,
  @JsonProperty("id"                    ) var id                    : String?                          = null,
  @JsonProperty("active"                ) var active                : Boolean?                         = null,
  @JsonProperty("createTime"            ) var createTime            : Int?                             = null,
  @JsonProperty("createdBy"             ) var createdBy             : String?                          = null,
  @JsonProperty("resellerId"            ) var resellerId            : String?                          = null,
  @JsonProperty("productType"           ) var productType           : ProductType?                     = ProductType(),
  @JsonProperty("category"              ) var category              : String?                          = null,
  @JsonProperty("name"                  ) var name                  : String?                          = null,
  @JsonProperty("bundle"                ) var bundle                : Boolean?                         = null,
  @JsonProperty("storable"              ) var storable              : Boolean?                         = null,
  @JsonProperty("widgetSpecific"        ) var widgetSpecific        : Boolean?                         = null,
  @JsonProperty("description"           ) var description           : String?                          = null,
  @JsonProperty("characteristicList"    ) var characteristicList    : ArrayList<String>                = arrayListOf(),
  @JsonProperty("serviceDefinitionList" ) var serviceDefinitionList : ArrayList<ServiceDefinitionList> = arrayListOf(),
  @JsonProperty("valid"                 ) var valid                 : Boolean?                         = null

)