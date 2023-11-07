package de.telran.bankapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
@ActiveProfiles("dev")
@WithMockUser(username = "admin", password = "admin")
class ManagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private ObjectMapper objectMapper;

    @Test
    void getAllTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/managers"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$[0].id").value(101L),
                        jsonPath("$[0].firstName").value("Major"),
                        jsonPath("$[0].lastName").value("Lora"),
                        jsonPath("$[1].id").value(102L),
                        jsonPath("$[1].firstName").value("Kilsh"),
                        jsonPath("$[1].lastName").value("Natalia"),
                        jsonPath("$[2].id").value(103L),
                        jsonPath("$[2].firstName").value("Amedov"),
                        jsonPath("$[2].lastName").value("Aram")
                );
    }

    @Test
    void getByIdTest() throws Exception {
        Long managerId = 101L;
        mockMvc.perform(MockMvcRequestBuilders.get("/managers/{id}", managerId))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.id").value(managerId),
                        jsonPath("$.firstName").value("Major"),
                        jsonPath("$.lastName").value("Lora")
                );
    }

    @Test
    void getManagersWithClientsTest() {
    }

    @Test
    void createTest() {
    }

    @Test
    void updateByIdTest() {
    }

    @Test
    void deleteByIdTest() {
    }

    @Test
    void getClientsByManagerIdTest() {
    }
}