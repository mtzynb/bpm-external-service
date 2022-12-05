package com.zitel.bpmexternalservice.application

import com.fasterxml.jackson.databind.ObjectMapper
import com.zitel.bpmexternalservice.common.ExecutorService
import com.zitel.bpmexternalservice.common.InputVariable
import com.zitel.bpmexternalservice.common.OutputVariable
import com.zitel.bpmexternalservice.common.ResponseDto
import org.springframework.stereotype.Service

@Service
class ApplicationService(
    executorServices: List<ExecutorService<*, *>>,
    private val mapper: ObjectMapper
) {

    private val namedExecutorServices: Map<String, ExecutorService<in InputVariable, out OutputVariable>> =
        executorServices.associateBy { it.type } as Map<String, ExecutorService<InputVariable, OutputVariable>>

    fun executorServices() = namedExecutorServices

    fun findExecutorService(type: String):
            ExecutorService<in InputVariable, out OutputVariable> =
        executorServices()[type] ?: throw NotImplementedError(type)


    fun delegateExecution(req: ApplicationRequestDto): ResponseDto {
        val executorService = findExecutorService(req.type)
        val inputVariables = mapper.convertValue(req.variables, executorService.inputClass) as InputVariable

        return executorService.execute(req, inputVariables)
    }
}
