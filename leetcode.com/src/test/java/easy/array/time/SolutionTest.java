package easy.array.time;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {
    Solution solution;

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 7),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }

    @BeforeEach
    void setUp() {
        System.out.println("Начало теста");
        solution = new Solution();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Окончание теста");
        solution = null;
    }

    @ParameterizedTest
    @MethodSource("source")
    void maxProfit(int[] array, int expected) {
        int result = solution.maxProfit(array);
        Assertions.assertEquals(expected, result);
    }
}