package com.alvaroserrano.price_service.infraestructure.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test 1: 14/06/2020 10:00 - product 35455 - brand 1")
    void test1() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("applicationDate", "2020-06-14T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    @DisplayName("Test 2: 14/06/2020 16:00 - product 35455 - brand 1")
    void test2() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("applicationDate", "2020-06-14T16:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    @DisplayName("Test 3: 14/06/2020 21:00 - product 35455 - brand 1")
    void test3() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("applicationDate", "2020-06-14T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    @DisplayName("Test 4: 15/06/2020 10:00 - product 35455 - brand 1")
    void test4() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("applicationDate", "2020-06-15T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(30.50));
    }

    @Test
    @DisplayName("Test 5: 16/06/2020 21:00 - product 35455 - brand 1")
    void test5() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("applicationDate", "2020-06-16T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(38.95));
    }
}