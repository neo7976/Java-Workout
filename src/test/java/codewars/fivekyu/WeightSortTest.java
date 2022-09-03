package codewars.fivekyu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WeightSortTest {
    WeightSort weightSort;

    @BeforeEach
    void setUp() {
        weightSort = new WeightSort();
    }

    @AfterEach
    void tearDown() {
        weightSort = null;
    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of(" 103 123      4444 99 2000 ", "2000 103 123 4444 99"),
                Arguments.of("2000 10003 1234000 44444444 9999 11 11 22 123", "11 11 2000 10003 22 123 1234000 44444444 9999")
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void orderWeight(String str, String expected) {
        Assertions.assertEquals(expected, weightSort.orderWeight(str));
    }

    @ParameterizedTest
    @MethodSource("source")
    void orderWeight1(String str, String expected) {
        Assertions.assertEquals(expected, weightSort.orderWeight1(str));
    }

    @ParameterizedTest
    @MethodSource("source")
    void orderWeight2(String str, String expected) {
        Assertions.assertEquals(expected, weightSort.orderWeight2(str));
    }
}