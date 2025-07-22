package com.cinema_package.cinema_project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration test for Movie REST API endpoints.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class MovieServiceImpTest {

    private static final Logger logger = LoggerFactory.getLogger(CinemaProjectApplication.class);

    public static void main(String[] args) {
        logger.info("🟢 Starting CinemaProjectApplication Testing");
    }

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test GET /movie/{id} endpoint to retrieve a movie by its ID.
     * Checks that the response status is OK (200),
     * content type is JSON, and returned movie has the expected ID.
     */
    @DisplayName("Get movie by Id")
    @Test
    public void getMovieByIdTest() throws Exception {
        // Build a GET request to /movie/1
        RequestBuilder request = MockMvcRequestBuilders.get("/movie/1");

        // Perform the request and assert the results
        mockMvc.perform(request)
            .andExpect(status().isOk())  // Expect HTTP 200
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))  // Expect JSON response
            .andExpect(jsonPath("$.id").value(1));  // Expect the JSON "id" field to be 1
    }
}
