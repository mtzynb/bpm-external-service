package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class AgreementItem (

  @JsonProperty("@ref" ) var _ref : String? = null

)