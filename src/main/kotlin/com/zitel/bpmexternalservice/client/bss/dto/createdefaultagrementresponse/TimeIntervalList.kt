package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class TimeIntervalList (

  @JsonProperty("@id"               ) var _id               : String?                = null,
  @JsonProperty("id"                ) var id                : String?                = null,
  @JsonProperty("active"            ) var active            : Boolean?               = null,
  @JsonProperty("createdBy"         ) var createdBy         : String?                = null,
  @JsonProperty("resellerId"        ) var resellerId        : String?                = null,
  @JsonProperty("timeUnit"          ) var timeUnit          : String?                = null,
  @JsonProperty("timeAmount"        ) var timeAmount        : Int?                   = null,
  @JsonProperty("channelList"       ) var channelList       : ArrayList<ChannelList> = arrayListOf(),
  @JsonProperty("specificationList" ) var specificationList : ArrayList<String>      = arrayListOf(),
  @JsonProperty("key"               ) var key               : String?                = null,
  @JsonProperty("title"             ) var title             : String?                = null,
  @JsonProperty("valid"             ) var valid             : Boolean?               = null

)