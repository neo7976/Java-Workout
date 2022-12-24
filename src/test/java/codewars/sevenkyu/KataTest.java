package codewars.sevenkyu;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
    Kata kata;

    @BeforeEach
    void setUp() {
        kata = new Kata();
    }

    @AfterEach
    void tearDown() {
        kata = null;
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(1, 1, "10"),
                Arguments.of(5, 9, "1110"),
                Arguments.of(10, 9, "10011"),
                Arguments.of(25, 26, "110011")
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void binaryAddition(int a, int b, String expected) {
        Assertions.assertEquals(expected, kata.binaryAddition(a, b));
    }
}