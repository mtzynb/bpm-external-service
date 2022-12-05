package com.zitel.bpmexternalservice.common

import java.lang.reflect.ParameterizedType


abstract class ExecutorService<REQ, RES> {
    abstract val type: String
    abstract val description: String

    private val classType = javaClass.genericSuperclass as ParameterizedType
    val inputClass: Class<REQ> = classType.actualTypeArguments[0] as Class<REQ>
    val outputClass: Class<RES> = classType.actualTypeArguments[1] as Class<RES>

    abstract fun execute(processRequestDto: ProcessRequestDto, variables: REQ): RES
}
