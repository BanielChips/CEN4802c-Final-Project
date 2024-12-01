package com.cen4802c.finalProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(springbootController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAdditionEndpoint() throws Exception {
        mockMvc.perform(get("/add")
                .param("a", "15")
                .param("b", "20"))
                .andExpect(status().isOk())
                .andExpect(content().string("35.0"));
    }

    @Test
    public void testSubtractionEndpoint() throws Exception {
        mockMvc.perform(get("/subtract")
                .param("a", "30")
                .param("b", "11"))
                .andExpect(status().isOk())
                .andExpect(content().string("19.0"));
    }

    @Test
    public void testMultiplicationEndpoint() throws Exception {
        mockMvc.perform(get("/multiply")
                .param("a", "10")
                .param("b", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("100.0"));
    }

    @Test
    public void testDivisionEndpoint() throws Exception {
        mockMvc.perform(get("/divide")
                .param("a", "30")
                .param("b", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));
    }

    @Test
    public void testDivideByZero() throws Exception {
        mockMvc.perform(get("/divide")
                .param("a", "5")
                .param("b", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Cannot divide by zero"));
    }
}

