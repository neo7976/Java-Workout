package codewars.sixkyu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KataTwoTest {
    KataTwo kata;

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(3, (new int[]{1, 2, 3, 4, 3, 2, 1})),
                Arguments.of(1, (new int[]{1, 100, 50, -51, 1, 1})),
                Arguments.of(-1, (new int[]{1, 2, 3, 4, 5, 6})),
                Arguments.of(3, (new int[]{20, 10, 30, 10, 10, 15, 35})),
                Arguments.of(-1, (new int[]{-8505, -5130, 1926, -9026})),
                Arguments.of(1, (new int[]{2824, 1774, -1490, -9084, -9696, 23094}))
        );
    }

    @BeforeEach
    void setUp() {
        kata = new KataTwo();
    }

    @AfterEach
    void tearDown() {
        kata = null;
    }

    @ParameterizedTest
    @MethodSource("source")
    void findEvenIndex(int expected, int[] arrays) {
        Assertions.assertEquals(expected, kata.findEvenIndex(arrays));
    }
}