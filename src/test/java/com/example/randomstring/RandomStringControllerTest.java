package com.example.randomstring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests for the RandomStringController.
 */
@WebMvcTest(RandomStringController.class)
class RandomStringControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test the home endpoint.
     */
    @Test
    void testHomeEndpoint() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Welcome to the Random String API"))
                .andExpect(jsonPath("$.endpoints").exists())
                .andExpect(jsonPath("$.endpoints['/random-string']").value("Returns a random string"));
    }

    /**
     * Test the random string endpoint.
     */
    @Test
    void testRandomStringEndpoint() throws Exception {
        mockMvc.perform(get("/random-string"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.random_string").exists())
                .andExpect(jsonPath("$.random_string").isString())
                .andExpect(jsonPath("$.random_string", hasLength(10)));
    }

    /**
     * Test that random strings are generated (multiple calls should work).
     */
    @Test
    void testRandomStringMultipleCalls() throws Exception {
        // First call
        mockMvc.perform(get("/random-string"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.random_string", hasLength(10)));

        // Second call
        mockMvc.perform(get("/random-string"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.random_string", hasLength(10)));
    }
}
