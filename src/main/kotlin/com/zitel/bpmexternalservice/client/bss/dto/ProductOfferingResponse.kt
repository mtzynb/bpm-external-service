

package com.zitel.bpmexternalservice.client.bss.dto

import com.fasterxml.jackson.annotation.JsonProperty


data class ProductOfferingResponse (

    @JsonProperty("@id")
    val _id: String,

    @JsonProperty("id")
    val id: String,

    val active: Boolean,
    val createTime: Long,
    val createdBy: String,

    @JsonProperty("resellerId")
    val resellerID: String,

    val product: Product,

    @JsonProperty("productDefinitionId")
    val productDefinitionID: String,

    val category: String,
    val name: String,
    val offerableChannels: List<OfferableChannel>,
    val presentable: Boolean,
    val bundle: Boolean,
    val timeIntervalList: List<TimeIntervalList>,
    val returnable: Boolean,
    val openRate: Boolean,
    val createdByWidget: Boolean,
    val expansion: Boolean,
    val dealType: String,
    val priceList: List<PriceList>,
    val discountList: List<Any?>,
    val bundledOfferingList: List<Any?>,
//    val bundleInstallOrder: BundleInstallOrder,
    val productSegmentList: List<String>,
    val valid: Boolean
)
//typealias BundleInstallOrder = JsonObject

data class OfferableChannel (
    @JsonProperty("@id")
    val id: String,

    val key: String,
    val value: String,
    val active: Boolean,
    val preDefined: Boolean,
    val displayOrder: Long,
    val defaultValue: Boolean
)

data class PriceList (
    @JsonProperty("@id")
    val id: String,

    @JsonProperty("id")
    val priceListID: String,

    val active: Boolean,
    val createTime: Long,
    val createdBy: String,

    @JsonProperty("resellerId")
    val resellerID: String,

    val validTimeInterval: ValidTimeInterval,
    val priceType: String,
    val name: String,
    val amount: Double,
    val currency: String,
    val timeInterval: TimeInterval,
    val returnable: Boolean,
    val discountable: Boolean,
    val allowedTransactions: List<Any?>,
    val quantityMeasureAmount: Double,
    val basePrice: Boolean,
    val tolerance: Double,
    val productOffering: ProductOffering,
    val discountList: List<Any?>,
    val valid: Boolean
)

data class ProductOffering (
    @JsonProperty("@ref")
    val ref: String
)

data class TimeInterval (
    val timeUnit: String,
    val timeAmount: Long,
    val key: String,
    val title: String
)

data class ValidTimeInterval (
    val validFromDateTime: Long
)

data class Product (
    @JsonProperty("@id")
    val id: String,

    @JsonProperty("id")
    val productID: String,

    val active: Boolean,
    val createTime: Long,
    val createdBy: String,

    @JsonProperty("resellerId")
    val resellerID: String,

    val productDefinition: ProductDefinition,
    val category: String,
    val code: String,
    val name: String,
    val bundle: Boolean,
    val countable: Boolean,
    val characteristicList: List<ProductCharacteristicList>,
    val valid: Boolean
)

data class ProductCharacteristicList (
    @JsonProperty("@id")
    val id: String,

    @JsonProperty("id")
    val characteristicListID: String,

    val active: Boolean,
    val createTime: Long,
    val createdBy: String,

    @JsonProperty("resellerId")
    val resellerID: String,

    val characteristicGroupList: List<String>,
    val key: String,
    val value: String,
    val valueType: String,
    val dataType: String,
    val characteristicValueList: List<CharacteristicValueList>,
    val mandatory: Boolean,
    val preDefined: Boolean,
    val monolingual: Boolean,
    val characteristicTypeList: List<String>,

    @JsonProperty("characteristicRefId")
    val characteristicRefID: String,

    @JsonProperty("parentRefId")
    val parentRefID: String,

    val sortOrder: Long,
    val valid: Boolean,
    val measureUnit: ProductOffering? = null
)

data class CharacteristicValueList (
    val key: String,
    val value: String,
    val sortOrder: Long,
    val active: Boolean
)

data class ProductDefinition (
    @JsonProperty("@id")
    val id: String,

    @JsonProperty("id")
    val productDefinitionID: String,

    val active: Boolean,
    val createTime: Long,
    val createdBy: String,

    @JsonProperty("resellerId")
    val resellerID: String,

    val productType: ProductType,
    val category: String,
    val name: String,
    val bundle: Boolean,
    val storable: Boolean,
    val manualInventory: Boolean,
    val widgetSpecific: Boolean,
    val warehouseType: String,
    val measureUnit: OfferableChannel,
    val description: String,
    val characteristicList: List<ProductDefinitionCharacteristicList>,
    val serviceDefinitionList: List<Any?>,
    val valid: Boolean
)

data class ProductDefinitionCharacteristicList (
    @JsonProperty("@id")
    val id: String,

    @JsonProperty("id")
    val characteristicListID: String,

    val active: Boolean,
    val createTime: Long,
    val createdBy: String,

    @JsonProperty("resellerId")
    val resellerID: String,

    val characteristicGroupList: List<String>,
    val key: String,
    val value: String,
    val valueType: String,
    val dataType: String,
    val characteristicValueList: List<CharacteristicValueList>,
    val mandatory: Boolean,
    val preDefined: Boolean,
    val monolingual: Boolean,
    val characteristicTypeList: List<String>,

    @JsonProperty("characteristicRefId")
    val characteristicRefID: String,

    @JsonProperty("parentRefId")
    val parentRefID: String,

    val sortOrder: Long,
    val valid: Boolean,
    val measureUnit: OfferableChannel? = null
)

data class ProductType (
    val key: String,
    val value: String,
    val type: String,
    val billable: Boolean
)

data class TimeIntervalList (
    @JsonProperty("@id")
    val id: String,

    @JsonProperty("id")
    val timeIntervalListID: String,

    val active: Boolean,
    val createTime: Long,
    val createdBy: String,

    @JsonProperty("resellerId")
    val resellerID: String,

    val timeUnit: String,
    val timeAmount: Long,
    val channelList: List<ProductOffering>,
    val specificationList: List<Any?>,
    val key: String,
    val title: String,
    val valid: Boolean,
    val offeringIntervalType: String? = null
)