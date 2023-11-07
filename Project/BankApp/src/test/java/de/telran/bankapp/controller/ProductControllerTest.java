package de.telran.bankapp.controller;

import de.telran.bankapp.entity.bank.Manager;
import de.telran.bankapp.entity.bank.Product;
import de.telran.bankapp.repository.bank.ManagerRepository;
import de.telran.bankapp.repository.bank.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static de.telran.bankapp.entity.enums.CurrencyCode.EUR;
import static de.telran.bankapp.entity.enums.ProductType.CREDIT_ACCOUNT;
import static de.telran.bankapp.entity.enums.Status.ACTIVE;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@WithMockUser(username = "test", password = "Test_123")
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void resetDb(
            @Autowired ProductRepository productRepository,
            @Autowired ManagerRepository managerRepository) {

        LocalDateTime currentDateTime = LocalDateTime.now();
        Manager manager = new Manager();
        manager.setFirstName("AAAAA");
        manager.setLastName("BBBBB");
        manager.setStatus(ACTIVE);
        manager.setDescription("ССССС");
        manager.setCreatedAt(currentDateTime);
        manager.setUpdatedAt(currentDateTime);

        Product product = new Product();
        product.setManager(manager);
        product.setType(CREDIT_ACCOUNT);
        product.setStatus(ACTIVE);
        product.setCurrencyCode(EUR);
        product.setInterestRate(new BigDecimal("8.6500"));
        product.setLimit(new BigDecimal("75000.00"));
        product.setCreatedAt(currentDateTime);
        product.setUpdatedAt(currentDateTime);

        productRepository.deleteAll();
        managerRepository.save(manager);
        productRepository.save(product);
    }

    @Test
    void getAllProductsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$").isArray(),
                        jsonPath("$").isNotEmpty(),
                        jsonPath("$", hasSize(1)),
                        jsonPath("$.[0].id").value(1)
                );
    }

    @Test
    void getByStatusAndCurrencyCodeTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/choose?status=ACTIVE&currencyCode=EUR"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$").isNotEmpty(),
                        jsonPath("$[0].id").value(1),
                        jsonPath("$[0].managerId").value(1L)
                );
    }

    @Test
    void getByNotStatusAndCurrencyCodeTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/choose?status=INACTIVE&currencyCode=USD"))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$").isEmpty()
                );
    }

    @Test
    void getByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/1"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$").isMap(),
                        jsonPath("$").isNotEmpty(),
                        jsonPath("$.id").value(1),
                        jsonPath("$.managerId").value(1L),
                        jsonPath("$.type").value("CREDIT_ACCOUNT"),
                        jsonPath("$.status").value("ACTIVE"),
                        jsonPath("$.currencyCode").value("EUR"),
                        jsonPath("$.interestRate").value(8.6500),
                        jsonPath("$.limit").value(75000),
                        jsonPath("$.createdAt").isNotEmpty(),
                        jsonPath("$.updatedAt").isString()
                );
    }

    @Test
    void getByIdNotFoundTest() throws Exception {
        long id = 99999;
        mockMvc.perform(MockMvcRequestBuilders.get("/products/" + id))
                .andExpect(status().isNotFound());
    }
}