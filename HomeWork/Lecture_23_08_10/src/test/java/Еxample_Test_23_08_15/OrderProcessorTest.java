package Еxample_Test_23_08_15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class OrderProcessorTest {

    private static final Person PERSON = new Person("Misha", 21, "Munchen, street 21","misha@gmail.com");
    private static final Product PRODUCT_1 = new Product("Milk", 1.99, 3, "Food");
    private static final Product PRODUCT_2 = new Product("Broot", 2.34, 2, "Food");
    private static final Product PRODUCT_3 = new Product("Wurst", 3.26, 1, "Food");
    private static final Order ORDER_1 = new Order(1,PERSON, new ArrayList<>(Arrays.asList(PRODUCT_1, PRODUCT_2)),
            LocalDate.of(2022, 2,12));
    private static final Order ORDER_2 = new Order(2,PERSON, new ArrayList<>(Arrays.asList(PRODUCT_2, PRODUCT_3)),
            LocalDate.now());
    private static final Order ORDER_3 = new Order(3,PERSON, new ArrayList<>(Arrays.asList(PRODUCT_1, PRODUCT_3)),
            LocalDate.now().plusMonths(1));
    private OrderProcessor orderProcessor;

    @BeforeEach
    void setUp() {
        orderProcessor = new OrderProcessor();
        orderProcessor.addOrder(ORDER_1);
        orderProcessor.addOrder(ORDER_2);
        orderProcessor.addOrder(ORDER_3);
    }

    @AfterEach
    void tearDown() {
        orderProcessor = null;
    }

    @Test
    void addOrderNullTestCase() {
        assertThrows(IllegalArgumentException.class, () -> orderProcessor.addOrder(null));
    }

    @Test
    void calculateTotalRevenueTest() {
    }

    @Test
    void getExpiredOrdersTest() {
    }
}