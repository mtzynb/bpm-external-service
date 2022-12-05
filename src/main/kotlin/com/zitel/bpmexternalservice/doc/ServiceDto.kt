package com.zitel.bpmexternalservice.doc

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.zitel.bpmexternalservice.common.InputVariable
import com.zitel.bpmexternalservice.common.OutputVariable
import org.springframework.util.ReflectionUtils

data class ServiceDto(
    val type: String,
    val description: String,
    @JsonIgnore
    val inputClass: Class<in InputVariable>? = null,
    @JsonIgnore
    val outputClass: Class<out OutputVariable>? = null,
    var inputs: List<ServiceFieldDto>? = null,
    var outputs: List<ServiceFieldDto>? = null
) {
    init {
        if (inputClass != null) {
            inputs = extractFieldNames(inputClass)
        }

        if (outputClass != null) {
            outputs = extractFieldNames(outputClass)
        }
    }

    private fun extractFieldNames(clazz: Class<*>): MutableList<ServiceFieldDto> {
        val inputs = mutableListOf<ServiceFieldDto>()
        ReflectionUtils.doWithFields(clazz) {
            var fieldName: String = it.name
            if (it.isAnnotationPresent(JsonProperty::class.java)) {
                fieldName = it.getAnnotation(JsonProperty::class.java).value
            } else if (clazz.constructors.isNotEmpty()) {
                for (constructor in clazz.constructors) {
                    for (parameter in constructor.parameters) {
                        val jsonProperty = parameter.getAnnotation(JsonProperty::class.java)
                        if (parameter.name.equals(it.name) && jsonProperty != null) {
                            fieldName = jsonProperty.value
                            break
                        }
                    }
                }
            }
            inputs.add(ServiceFieldDto(fieldName, it.type.simpleName))
        }
        return inputs
    }
}