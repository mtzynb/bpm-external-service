package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty


data class AgreementItemList (

  @JsonProperty("@id"               ) var _id               : String?                      = null,
  @JsonProperty("id"                ) var id                : String?                      = null,
  @JsonProperty("active"            ) var active            : Boolean?                     = null,
  @JsonProperty("createTime"        ) var createTime        : Int?                         = null,
  @JsonProperty("createdBy"         ) var createdBy         : String?                      = null,
  @JsonProperty("resellerId"        ) var resellerId        : String?                      = null,
  @JsonProperty("agreement"         ) var agreement         : Agreement?                   = Agreement(),
  @JsonProperty("productOffering"   ) var productOffering   : ProductOffering?             = ProductOffering(),
  @JsonProperty("timeInterval"      ) var timeInterval      : TimeInterval?                = TimeInterval(),
  @JsonProperty("specificationList" ) var specificationList : ArrayList<SpecificationList> = arrayListOf(),
  @JsonProperty("itemCount"         ) var itemCount         : Int?                         = null,
  @JsonProperty("dealList"          ) var dealList          : ArrayList<DealList>          = arrayListOf(),
  @JsonProperty("discountList"      ) var discountList      : ArrayList<String>            = arrayListOf(),
  @JsonProperty("detached"          ) var detached          : Boolean?                     = null,
  @JsonProperty("valid"             ) var valid             : Boolean?                     = null

)