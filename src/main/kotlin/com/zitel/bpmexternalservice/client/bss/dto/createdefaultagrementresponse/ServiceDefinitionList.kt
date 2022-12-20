package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class ServiceDefinitionList (

  @JsonProperty("@id"                ) var _id                : String?                       = null,
  @JsonProperty("id"                 ) var id                 : String?                       = null,
  @JsonProperty("active"             ) var active             : Boolean?                      = null,
  @JsonProperty("createTime"         ) var createTime         : Int?                          = null,
  @JsonProperty("createdBy"          ) var createdBy          : String?                       = null,
  @JsonProperty("resellerId"         ) var resellerId         : String?                       = null,
  @JsonProperty("category"           ) var category           : String?                       = null,
  @JsonProperty("name"               ) var name               : String?                       = null,
  @JsonProperty("storable"           ) var storable           : Boolean?                      = null,
  @JsonProperty("warehouseType"      ) var warehouseType      : String?                       = null,
  @JsonProperty("description"        ) var description        : String?                       = null,
  @JsonProperty("characteristicList" ) var characteristicList : ArrayList<CharacteristicList> = arrayListOf(),
  @JsonProperty("regulationFree"     ) var regulationFree     : Boolean?                      = null,
  @JsonProperty("valid"              ) var valid              : Boolean?                      = null

)