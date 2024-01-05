package org.example;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class RandomOddNumberTest {

    @Test
    void generateRandomOddNumberTest() {
        Random mockRandom = mock(Random.class);
        int[] newValue = {-99, -43, -15, 1, 39, 57, 99};
        for (int i = 0; i < newValue.length; i++) {
            assertTrue(newValue[i] < 100);
            assertTrue(newValue[i] > -100);
            assertTrue(newValue[i] % 2 != 0);
            when(mockRandom.nextInt(201)).thenReturn(newValue[i] + 100);
            int value = RandomOddNumber.generateRandomOddNumber(mockRandom);
            assertEquals(newValue[i], value);
        }
    }
}
