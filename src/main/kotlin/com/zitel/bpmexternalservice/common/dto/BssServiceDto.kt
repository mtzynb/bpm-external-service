package com.zitel.bpmexternalservice.common.dto

class BssServiceDto


data class Characteristic(
    val selectedValue: String,
    val selectedValueLabel: String,
    val key: String,
    val keyLabel: String,
    var characteristicId: String?,
    val monolingual: String,
    val sortOrder: String
)



