
/**
 * Test class for BinaryController
 * Tests web application functionality for binary calculator
 */
package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testAddition() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operator","+").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(model().attribute("result", "10001"));
    }

    @Test
    public void testMultiplication() throws Exception {
        this.mvc.perform(post("/").param("operand1","101").param("operator","*").param("operand2","11"))
            .andExpect(status().isOk())
            .andExpect(model().attribute("result", "1111"));
    }

    @Test
    public void testBitwiseAND() throws Exception {
        this.mvc.perform(post("/").param("operand1","1101").param("operator","&").param("operand2","1011"))
            .andExpect(status().isOk())
            .andExpect(model().attribute("result", "1001"));
    }

    @Test
    public void testBitwiseOR() throws Exception {
        this.mvc.perform(post("/").param("operand1","1100").param("operator","|").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(model().attribute("result", "1110"));
    }

    @Test
    public void testInvalidOperator() throws Exception {
        this.mvc.perform(post("/").param("operand1","11").param("operator","!").param("operand2","11"))
            .andExpect(status().isOk())
            .andExpect(view().name("error"));
    }
}