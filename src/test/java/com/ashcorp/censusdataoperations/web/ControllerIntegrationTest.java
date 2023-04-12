package com.ashcorp.censusdataoperations.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerIntegrationTest {

    /**
	* Declare MockMvc object.
	*/
    @Autowired
    private MockMvc mockMvc;

    /**
    * Request should return the seed data record.
	*/
    @Test
    public void shouldReturnSeedData() throws Exception {
        this.mockMvc.perform(get("/data/census/1001020100"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.state").value("NY"));
    }
}
