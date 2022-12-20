package com.zitel.bpmexternalservice.client.bss.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class GetEmployeeByUserIdResponse(
    @JsonProperty("@id")
    val _id: String,

    @JsonProperty("id")
    val id: String,

    val active: Boolean,
    val createTime: Long,
    val createdBy: String,

    @JsonProperty("resellerId")
    val resellerID: String,

    val user: User,
    val party: Party,
    val employeeNumber: String,
    val specificationList: List<Any?>,
    val contactCenter: ContactCenter,
    val storageFiles: List<Any?>,
    val telephonyInfo: TelephonyInfo,
    val maxAllowedDiscountPrice: Double,
    val maxAllowedDiscountPercentage: Double,
    val valid: Boolean
)

data class ContactCenter(
    @JsonProperty("@id")
    val id: String,

    @JsonProperty("id")
    val contactCenterID: String,

    val active: Boolean,
    val createTime: Long,
    val createdBy: String,

    @JsonProperty("resellerId")
    val resellerID: String,

    val name: String,
    val interactionSubjects: List<Nationality>,
    val interactionReasons: List<CallQueue>,
    val interactionResults: List<Nationality>,
    val callQueues: List<CallQueue>,
    val valid: Boolean
)

data class CallQueue(
    @JsonProperty("@id")
    val id: String? = null,

    @JsonProperty("id")
    val callQueueID: String? = null,

    val active: Boolean? = null,
    val createTime: Long? = null,
    val createdBy: String? = null,

    @JsonProperty("resellerId")
    val resellerID: String? = null,

    val key: String? = null,
    val name: String? = null,
    val priority: Long? = null,
    val valid: Boolean? = null,
    val interactionSubject: List<Nationality>? = null,

    @JsonProperty("@ref")
    val ref: String? = null
)

data class Nationality(
    @JsonProperty("@ref")
    val ref: String? = null,

    @JsonProperty("@id")
    val id: String? = null,

    val key: String? = null,
    val value: String? = null,
    val active: Boolean? = null,
    val preDefined: Boolean? = null,
    val displayOrder: Long? = null,
    val defaultValue: Boolean? = null
)

data class Party(
    @JsonProperty("@id")
    val id: String,

    @JsonProperty("id")
    val partyID: String,

    val active: Boolean,
    val createTime: Long,
    val createdBy: String,

    @JsonProperty("resellerId")
    val resellerID: String,

    val identification: Identification,
    val partyType: String,
    val fullName: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val nationality: Nationality,
    val mediumList: List<MediumList>,
    val editable: Boolean,
    val valid: Boolean
)

data class Identification(
    val value: String,
    val identificationType: String
)

data class MediumList(
    @JsonProperty("@id")
    val id: String,

    @JsonProperty("id")
    val mediumListID: String,

    val active: Boolean,
    val createTime: Long,
    val createdBy: String,

    @JsonProperty("resellerId")
    val resellerID: String,

    val mediumType: String,
    val value: String,
    val defaultInType: Boolean,
    val party: DefaultCallQueue,
    val valid: Boolean
)

data class DefaultCallQueue(
    @JsonProperty("@ref")
    val ref: String? = null
)

data class TelephonyInfo(
    val defaultExtension: String,
    val defaultCallQueue: DefaultCallQueue,
    val allowedCallQueues: List<CallQueue>,
    val allowedContactCenters: List<AllowedContactCenter>,
    val voipStatistics: List<VoipStatistic?>?,
    val lastChangeVoipStatusTime: Long,
    val voipCurrentStatus: VoipStatus?,
    val voipPauseType: DefaultCallQueue?
)

data class AllowedContactCenter(
    @JsonProperty("@id")
    val id: String? = null,

    @JsonProperty("id")
    val allowedContactCenterID: String? = null,

    val active: Boolean? = null,
    val createTime: Long? = null,
    val createdBy: String? = null,

    @JsonProperty("resellerId")
    val resellerID: String? = null,

    val name: String? = null,
    val interactionSubjects: List<Nationality>? = null,
    val interactionReasons: List<CallQueue>? = null,
    val interactionResults: List<DefaultCallQueue>? = null,
    val callQueues: List<CallQueue>? = null,
    val valid: Boolean? = null,

    @JsonProperty("@ref")
    val ref: String? = null
)

enum class VoipStatus {
    PAUSE, READY
}

data class VoipStatistic(
    @JsonProperty("@id")
    val id: String,

    @JsonProperty("id")
    val voipStatisticID: String,

    val active: Boolean,
    val createTime: Long,
    val createdBy: String,

    @JsonProperty("resellerId")
    val resellerID: String,

    val employee: DefaultCallQueue,
    val voipStatus: VoipStatus?,
    val endTime: Long? = null,
    val valid: Boolean,
    val voipPauseType: Nationality? = null,
    val callQueue: DefaultCallQueue? = null,
    val extension: String? = null
)

data class User(
    val id: String,
    val username: String,
    val password: String,
    val lastOnlineTime: Long,
    val online: Boolean
)
