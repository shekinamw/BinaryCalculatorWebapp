package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

/**
 * Test class for BinaryAPIController
 * Tests RESTful API functionality for binary calculator
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testAdd() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }

    @Test
    public void testMultiplyJSON() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","101").param("operand2","11"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value("1111"));
    }

    @Test
    public void testANDJSON() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","1101").param("operand2","1011"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value("1001"));
    }

    @Test
    public void testORJSON() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","1100").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value("1110"));
    }

    @Test
    public void testEmptyParameters() throws Exception {
        this.mvc.perform(get("/add").param("operand1","").param("operand2",""))
            .andExpect(status().isOk()) // Assuming Binary class converts empty to "0"
            .andExpect(content().string("0"));
    }
}