package codewars.sixkyu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @AfterEach
    void tearDown() {
        solution = null;
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(9, new int[]{2, 2, 3, 3, 4, 4}, 2),
                Arguments.of(12, new int[]{5,3,4}, 1),
                Arguments.of(10, new int[]{10,2,3,3}, 2),
                Arguments.of(12, new int[]{2,3,10}, 2),
                Arguments.of(0, new int[]{}, 1),
                Arguments.of(15, new int[]{1, 2, 3, 4, 5}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void solveSuperMarketQueue(int expected, int[] array, int n) throws ExecutionException, InterruptedException {
        Assertions.assertEquals(expected, solution.solveSuperMarketQueue(array, n), "Тест не прошел");
    }
}