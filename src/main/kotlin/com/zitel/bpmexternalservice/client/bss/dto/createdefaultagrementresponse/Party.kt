package com.zitel.bpmexternalservice.client.bss.dto.createdefaultagrementresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class Party (

  @JsonProperty("@id"                    ) var _id                    : String?               = null,
  @JsonProperty("id"                     ) var id                     : String?               = null,
  @JsonProperty("active"                 ) var active                 : Boolean?              = null,
  @JsonProperty("createTime"             ) var createTime             : Int?                  = null,
  @JsonProperty("createdBy"              ) var createdBy              : String?               = null,
  @JsonProperty("resellerId"             ) var resellerId             : String?               = null,
  @JsonProperty("identification"         ) var identification         : Identification?       = Identification(),
  @JsonProperty("partyType"              ) var partyType              : String?               = null,
  @JsonProperty("fullName"               ) var fullName               : String?               = null,
  @JsonProperty("firstName"              ) var firstName              : String?               = null,
  @JsonProperty("lastName"               ) var lastName               : String?               = null,
  @JsonProperty("gender"                 ) var gender                 : String?               = null,
  @JsonProperty("fatherName"             ) var fatherName             : String?               = null,
  @JsonProperty("birthCertificateNumber" ) var birthCertificateNumber : String?               = null,
  @JsonProperty("birthDate"              ) var birthDate              : String?               = null,
  @JsonProperty("nationality"            ) var nationality            : Nationality?          = Nationality(),
  @JsonProperty("educationLevel"         ) var educationLevel         : EducationLevel?       = EducationLevel(),
  @JsonProperty("birthPlace"             ) var birthPlace             : String?               = null,
  @JsonProperty("mediumList"             ) var mediumList             : ArrayList<MediumList> = arrayListOf(),
  @JsonProperty("valid"                  ) var valid                  : Boolean?              = null

)