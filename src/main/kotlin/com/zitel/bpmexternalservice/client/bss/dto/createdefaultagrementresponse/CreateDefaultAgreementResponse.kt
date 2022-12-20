package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateDefaultAgreementResponse (

  @JsonProperty("@id"                  ) var _id                  : String?                      = null,
  @JsonProperty("id"                   ) var id                   : String?                      = null,
  @JsonProperty("active"               ) var active               : Boolean?                     = null,
  @JsonProperty("createTime"           ) var createTime           : Int?                         = null,
  @JsonProperty("createdBy"            ) var createdBy            : String?                      = null,
  @JsonProperty("resellerId"           ) var resellerId           : String?                      = null,
  @JsonProperty("documentType"         ) var documentType         : String?                      = null,
  @JsonProperty("documentHeader"       ) var documentHeader       : DocumentHeader?              = DocumentHeader(),
  @JsonProperty("customer"             ) var customer             : Customer?                    = Customer(),
  @JsonProperty("purchaseOrderId"      ) var purchaseOrderId      : String?                      = null,
  @JsonProperty("contract"             ) var contract             : Contract?                    = Contract(),
  @JsonProperty("currency"             ) var currency             : String?                      = null,
  @JsonProperty("description"          ) var description          : String?                      = null,
  @JsonProperty("agreementItemList"    ) var agreementItemList    : ArrayList<AgreementItemList> = arrayListOf(),
  @JsonProperty("deliveryProvinceCity" ) var deliveryProvinceCity : String?                      = null,
  @JsonProperty("deliveryAddress"      ) var deliveryAddress      : String?                      = null,
  @JsonProperty("deliveryGeoLocation"  ) var deliveryGeoLocation  : String?                      = null,
  @JsonProperty("deliveryPostalCode"   ) var deliveryPostalCode   : String?                      = null,
  @JsonProperty("discountList"         ) var discountList         : ArrayList<String>            = arrayListOf(),
  @JsonProperty("isFinancialCustomer"  ) var isFinancialCustomer  : Boolean?                     = null,
  @JsonProperty("valid"                ) var valid                : Boolean?                     = null

)