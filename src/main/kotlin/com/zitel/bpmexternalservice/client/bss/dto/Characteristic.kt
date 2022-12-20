package com.zitel.bpmexternalservice.client.bss.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class Characteristic(
    val selectedValue: String,
    val selectedValueLabel: String,
    val key: String,
    val keyLabel: String,

    @JsonProperty("characteristicId")
    val characteristicID: CharacteristicID,

    val monolingual: Boolean,
    val sortOrder: Long
)

data class CharacteristicID(
    val id: String
)