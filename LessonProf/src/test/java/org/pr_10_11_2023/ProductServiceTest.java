package org.pr_10_11_2023;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pr_10_11_2023_Mockito.MerchService;
import org.pr_10_11_2023_Mockito.Product;
import org.pr_10_11_2023_Mockito.ProductService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    private ProductService service;
    private MerchService merchService;

    @BeforeEach
    public void init() {
        merchService = mock(MerchService.class);
        service = new ProductService();
        service.setMerchService(merchService);
        service.save(new Product("Банан", 120, "Лучшие бананы"));
        service.save(new Product("Яблоко", 80, "Лучшие яблоки"));
        service.save(new Product("Апельсин", 200, "Лучшие апельсины"));
    }

    @Test
    public void checkIfProductsContainsSupplierInfo() {
        List<Product> products = service.getAll();
        for (Product product : products) {
            assertNotNull(product.getSupplier());
        }
    }

    @Test
    public void checkIfSupplierInfoIsNull() {
        when(merchService.withoutSupplierInfo()).thenReturn(true);
        List<Product> products = service.getAll();
        for (Product product : products) {
            assertNull(product.getSupplier());
        }
    }

    @Test
    public void checkCorrectMarkup() {
        when(merchService.getMarkup()).thenReturn(30.0);
        Product product = service.getById(1);
        double expectedPrice = 156;
        double actualPrice = product.getPrice();
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void checkIfArticlWasSuccessfullySet() {
        Product product = new Product("Test name", 777, "Test supplier");
        String testArticle = "Test article";
        doAnswer(x -> {
            Product product1 = x.getArgument(0);
            product1.setArticle(testArticle);
            return product1;
        }).when(merchService).setArticle(product);
        product = service.save(product);
        product = service.getById(4);
        assertNotNull(product);
        assertEquals(testArticle, product.getArticle());
    }

    @Test
    public void mockAndSpyDemo() {
        Product realProduct = new Product("Real name", 321, "Real supplier");
        service.save(realProduct);
        ProductService mock = mock(ProductService.class);
        ProductService spy = spy(service);

        mock.save(realProduct);

        Product product1 = new Product("Test name 1", 111, "Test supplier 1");
        Product product2 = new Product("Test name 2", 222, "Test supplier 2");
        List<Product> products = List.of(product1, product2);
        when(mock.getAll()).thenReturn(products);
        when(spy.getAll()).thenReturn(products);

        System.out.println();
        System.out.println("Переопределенное поведение mock и spy");
        System.out.println("Mock: " + mock.getAll());
        System.out.println("Spy: " + spy.getAll());

        System.out.println();
        System.out.println("Если мы не переопределяем поведение mock и spy");
        System.out.println("Mock: " + mock.getById(3));
        System.out.println("Spy: " + spy.getById(3));
    }

    @Test
    void setMerchService() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void save() {
    }

    @Test
    public void checkFulldeletion() {
        when(merchService.fullDeletion()).thenReturn(true);
        Product testProduct = new Product("Test name", 777, "Test supplier");
        testProduct = service.save(testProduct);
        int id = testProduct.getId();
        service.delete(id);
        testProduct = service.getById(id);
        assertNull(testProduct);
    }

    @Test
    public void checkIfInactiveStatusWasSet() {
        Product testProduct = new Product("Test name", 333, "Test supplier");
        testProduct = service.save(testProduct);
        int id = testProduct.getId();
        service.delete(id);
        testProduct = service.getById(id);
        assertNotNull(testProduct);
        assertFalse(testProduct.isActive());
    }
}