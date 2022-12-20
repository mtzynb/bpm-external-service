package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty



data class CharacteristicList (

  @JsonProperty("@id"                     ) var _id                     : String?           = null,
  @JsonProperty("id"                      ) var id                      : String?           = null,
  @JsonProperty("active"                  ) var active                  : Boolean?          = null,
  @JsonProperty("createTime"              ) var createTime              : Int?              = null,
  @JsonProperty("createdBy"               ) var createdBy               : String?           = null,
  @JsonProperty("resellerId"              ) var resellerId              : String?           = null,
  @JsonProperty("characteristicGroupList" ) var characteristicGroupList : ArrayList<String> = arrayListOf(),
  @JsonProperty("key"                     ) var key                     : String?           = null,
  @JsonProperty("value"                   ) var value                   : String?           = null,
  @JsonProperty("valueType"               ) var valueType               : String?           = null,
  @JsonProperty("valueClass"              ) var valueClass              : String?           = null,
  @JsonProperty("dataType"                ) var dataType                : String?           = null,
  @JsonProperty("characteristicValueList" ) var characteristicValueList : ArrayList<String> = arrayListOf(),
  @JsonProperty("mandatory"               ) var mandatory               : Boolean?          = null,
  @JsonProperty("preDefined"              ) var preDefined              : Boolean?          = null,
  @JsonProperty("monolingual"             ) var monolingual             : Boolean?          = null,
  @JsonProperty("characteristicTypeList"  ) var characteristicTypeList  : ArrayList<String> = arrayListOf(),
  @JsonProperty("characteristicRefId"     ) var characteristicRefId     : String?           = null,
  @JsonProperty("parentRefId"             ) var parentRefId             : String?           = null,
  @JsonProperty("sortOrder"               ) var sortOrder               : Int?              = null,
  @JsonProperty("valid"                   ) var valid                   : Boolean?          = null

)