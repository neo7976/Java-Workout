package codewars.fivekyu;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GreedTest {
    Greed greed;

    @BeforeEach
    void setUp() {
        System.out.println("Начало тестирования");
        greed = new Greed();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Окончание тестирования");
        greed = null;
    }


    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of((new int[]{5, 1, 3, 4, 1}), 250),
                Arguments.of((new int[]{1, 1, 1, 3, 1}), 1100),
                Arguments.of((new int[]{2, 4, 4, 5, 4}), 450)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testExample(int[] array, int expected) {
        assertEquals(expected, greed.greedy(array));
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testExample1(int[] array, int expected) {
        assertEquals(expected, greed.greedy1(array));
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testExample2(int[] array, int expected) {
        assertEquals(expected, greed.greedy2(array));
    }
}
