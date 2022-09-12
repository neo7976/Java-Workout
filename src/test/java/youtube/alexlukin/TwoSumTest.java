package youtube.alexlukin;

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

class TwoSumTest {
    TwoSum twoSum;

    @BeforeEach
    void setUp() {
        twoSum = new TwoSum();
    }

    @AfterEach
    void tearDown() {
        twoSum = null;
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(new int[]{-1, 2, 5, 8}, 7, new int[]{2, 5}),
                Arguments.of(new int[]{-3, -1, 0, 2, 6}, 6, new int[]{0, 6}),
                Arguments.of(new int[]{-1, 2, 5, 8}, 8, new int[]{}),
                Arguments.of(new int[]{-2, -1, 1, 2}, 0, new int[]{-1, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void twoSum_test(int[] array, int k, int[] expected) {
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(twoSum.twoSum(array, k)));
    }


    public static Stream<Arguments> source2() {
        return Stream.of(
                Arguments.of(new int[]{-1, 2, 5, 8}, 7, new int[]{-1, 8}),
                Arguments.of(new int[]{-3, -1, 0, 2, 6}, 6, new int[]{0, 6}),
                Arguments.of(new int[]{-1, 2, 5, 8}, 8, new int[]{}),
                Arguments.of(new int[]{-9, -5, -2, -1, 1, 4, 9, 11}, 3, new int[]{-1, 4}),
                Arguments.of(new int[]{-2, -1, 1, 2}, 0, new int[]{-2, 2})

        );
    }

    @ParameterizedTest
    @MethodSource("source2")
    void twoSumBinary_test(int[] array, int k, int[] expected) {
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(twoSum.twoSumBinary(array, k)));
    }

    @ParameterizedTest
    @MethodSource("source2")
    void twoSumLine_test(int[] array, int k, int[] expected) {
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(twoSum.twoSumLine(array, k)));
    }
}