package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class DealList (

  @JsonProperty("@id"                ) var _id                : String?              = null,
  @JsonProperty("id"                 ) var id                 : String?              = null,
  @JsonProperty("active"             ) var active             : Boolean?             = null,
  @JsonProperty("createTime"         ) var createTime         : Int?                 = null,
  @JsonProperty("createdBy"          ) var createdBy          : String?              = null,
  @JsonProperty("resellerId"         ) var resellerId         : String?              = null,
  @JsonProperty("documentType"       ) var documentType       : String?              = null,
  @JsonProperty("documentHeader"     ) var documentHeader     : DocumentHeader?      = DocumentHeader(),
  @JsonProperty("dealType"           ) var dealType           : String?              = null,
  @JsonProperty("agreementItem"      ) var agreementItem      : AgreementItem?       = AgreementItem(),
  @JsonProperty("productOffering"    ) var productOffering    : ProductOffering?     = ProductOffering(),
  @JsonProperty("category"           ) var category           : String?              = null,
  @JsonProperty("itemCount"          ) var itemCount          : Int?                 = null,
  @JsonProperty("timeInterval"       ) var timeInterval       : TimeInterval?        = TimeInterval(),
  @JsonProperty("priceList"          ) var priceList          : ArrayList<PriceList> = arrayListOf(),
  @JsonProperty("discountList"       ) var discountList       : ArrayList<String>    = arrayListOf(),
  @JsonProperty("sortOrder"          ) var sortOrder          : Int?                 = null,
  @JsonProperty("dynamicPricePolicy" ) var dynamicPricePolicy : Boolean?             = null,
  @JsonProperty("delivered"          ) var delivered          : Boolean?             = null,
  @JsonProperty("valid"              ) var valid              : Boolean?             = null

)