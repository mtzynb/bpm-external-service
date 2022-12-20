package com.zitel.bpmexternalservice.application

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
internal class ApplicationControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should validate availability of LTE-Modem device in warehouse----and return true`() {

        //given
//        mockMvc.post("/api/execute")
//            .andDo { print() }
//            .andExpect {
//                status { isOk() }
//                content { contentType(MediaType.APPLICATION_JSON) }
//                jsonPath("$[0].")
//            }


        //when


        //then

    }


}