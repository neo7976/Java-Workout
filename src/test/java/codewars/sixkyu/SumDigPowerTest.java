package codewars.sixkyu;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class SumDigPowerTest {
    SumDigPower sumDigPower;

    private static void testing(long a, long b, long[] res) {
        assertEquals(Arrays.toString(res),
                Arrays.toString(SumDigPower.sumDigPow(a, b).toArray()));
    }

    @BeforeEach
    void setUp() {
        sumDigPower = new SumDigPower();
    }

    @AfterEach
    void tearDown() {
        sumDigPower = null;
    }

    @Test
    public void test() {
        System.out.println("Basic Tests");
        testing(1, 10, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        testing(1, 100, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 89});
        testing(10, 100, new long[]{89});
        testing(90, 100, new long[]{});
        testing(90, 150, new long[]{135});
        testing(50, 150, new long[]{89, 135});
        testing(10, 150, new long[]{89, 135});
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(1, 10, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9}),
                Arguments.of(1, 100, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 89}),
                Arguments.of(10, 100, new long[]{89}),
                Arguments.of(90, 100, new long[]{}),
                Arguments.of(90, 150, new long[]{135}),
                Arguments.of(50, 150, new long[]{89, 135}),
                Arguments.of(10, 150, new long[]{89, 135})
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void sumDigPow1(long a, long b, long[] res) {
        Assertions.assertEquals(Arrays.toString(res), Arrays.toString(sumDigPower.sumDigPow1(a, b).toArray()));
    }
}

