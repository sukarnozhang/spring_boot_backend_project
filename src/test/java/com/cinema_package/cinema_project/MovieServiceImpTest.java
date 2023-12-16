package com.cinema_package.cinema_project;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieServiceImpTest {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(CinemaProjectApplication.class);
	public static void main (String[]args) {
		logger.info("🟢 Starting MySpringbootProjectApplication Testing");
	}
	
    @Autowired
    private MockMvc mockMvc;

    // @Autowired
    // private ObjectMapper objectMapper;

    @DisplayName("Get movie by Id")
    @Test
    public void getMovieByIdTest() throws Exception {
        // Step 1: Build a GET request to /movie/1
        RequestBuilder request = MockMvcRequestBuilders.get("/movie/1");

        // Step 2: Perform the request
        mockMvc.perform(request)
            // Assert that the status code is 200
            .andExpect(status().isOk())
            // Assert that the content type is JSON
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            // Assert that the id returned is 1
            .andExpect(jsonPath("$.id").value(1));
    }

}
