package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class PriceList (

  @JsonProperty("@id"                   ) var _id                   : String?           = null,
  @JsonProperty("id"                    ) var id                    : String?           = null,
  @JsonProperty("active"                ) var active                : Boolean?          = null,
  @JsonProperty("createTime"            ) var createTime            : Int?              = null,
  @JsonProperty("createdBy"             ) var createdBy             : String?           = null,
  @JsonProperty("resellerId"            ) var resellerId            : String?           = null,
  @JsonProperty("priceType"             ) var priceType             : String?           = null,
  @JsonProperty("name"                  ) var name                  : String?           = null,
  @JsonProperty("amount"                ) var amount                : Int?              = null,
  @JsonProperty("currency"              ) var currency              : String?           = null,
  @JsonProperty("timeInterval"          ) var timeInterval          : TimeInterval?     = TimeInterval(),
  @JsonProperty("returnable"            ) var returnable            : Boolean?          = null,
  @JsonProperty("discountable"          ) var discountable          : Boolean?          = null,
  @JsonProperty("allowedTransactions"   ) var allowedTransactions   : ArrayList<String> = arrayListOf(),
  @JsonProperty("quantityMeasureAmount" ) var quantityMeasureAmount : Int?              = null,
  @JsonProperty("deal"                  ) var deal                  : Deal?             = Deal(),
  @JsonProperty("billed"                ) var billed                : Boolean?          = null,
  @JsonProperty("parentPriceRefId"      ) var parentPriceRefId      : String?           = null,
  @JsonProperty("discountList"          ) var discountList          : ArrayList<String> = arrayListOf(),
  @JsonProperty("productOfferingId"     ) var productOfferingId     : String?           = null,
  @JsonProperty("valid"                 ) var valid                 : Boolean?          = null

)