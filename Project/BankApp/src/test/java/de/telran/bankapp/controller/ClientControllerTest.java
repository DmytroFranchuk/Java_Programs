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

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
@ActiveProfiles("dev")
@WithMockUser(username = "admin", password = "admin")
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/clients"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$").isArray(),
                        jsonPath("$").isNotEmpty(),
                        jsonPath("$", hasSize(6))
                );
    }

    @Test
    void getAllNotFoundTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/clients/invalid-url"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getByIdTest() throws Exception {
        long id = 20000104L;
        mockMvc.perform(MockMvcRequestBuilders.get("/clients/" + id))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.id").value(id),
                        jsonPath("$.managerId").value(102),
                        jsonPath("$.status").value("ACTIVE"),
                        jsonPath("$.taxCode").value("267a4cae-5332-11ee-2"),
                        jsonPath("$.firstName").value("Serjio"),
                        jsonPath("$.lastName").value("Shuter"),
                        jsonPath("$.email").value("moreman56@gmail.com"),
                        jsonPath("$.address").value("Leteria 218"),
                        jsonPath("$.phone").value("491785009832"),
                        jsonPath("$.createdAt").isNotEmpty(),
                        jsonPath("$.updatedAt").isNotEmpty()
                );
        id = 404L;
        mockMvc.perform(MockMvcRequestBuilders.get("/clients/" + id))
                .andExpectAll(
                        status().isNotFound(),
                        content().string("Client is id " + id + " not find")
                );
    }

    @Test
    void getByIdNotFoundTest() throws Exception {
        long id = 99999;
        mockMvc.perform(MockMvcRequestBuilders.get("/clients/" + id))
                .andExpect(status().isNotFound());
    }
}