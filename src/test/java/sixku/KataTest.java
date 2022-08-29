package sixku;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KataTest {
    Kata kata;

    @BeforeEach
    void setUp() {
        System.out.println("Начало теста");
        kata = new Kata();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Окончание теста");
        kata = null;
    }

    @Test
    void createPhoneNumber1() {
        Assertions.assertEquals("(123) 456-7890", Kata.createPhoneNumber1(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }


    @Test
    void createPhoneNumber2() {
        Assertions.assertEquals("(123) 456-7890", Kata.createPhoneNumber2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}