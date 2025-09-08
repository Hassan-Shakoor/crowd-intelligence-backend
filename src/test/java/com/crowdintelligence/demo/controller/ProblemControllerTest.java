package com.crowdintelligence.demo.controller;

import com.crowdintelligence.demo.repository.ProblemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProblemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProblemRepository problemRepository;

    @Test
    void testCreateAndGetProblem() throws Exception {
        String problemJson = """
            {
                "seekerId":"usr_1",
                "title":"Conveyor jam",
                "narrative":"Keeps failing under load"
            }
            """;

        // Create
        mockMvc.perform(post("/api/v1/problems")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-Tenant-Id", "companyA")
                        .content(problemJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUBMITTED"));

        // List
        mockMvc.perform(get("/api/v1/problems")
                        .header("X-Tenant-Id", "companyA"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Conveyor jam"));
    }
}
