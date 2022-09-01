package sixku;

import codewars.sixku.DRoot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DRootTest {
    DRoot dRoot;

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(16, 7),
                Arguments.of(942, 6),
                Arguments.of(132189, 6),
                Arguments.of(493193, 2),
                Arguments.of(456, 6)
        );
    }

    @BeforeEach
    void setUp() {
        dRoot = new DRoot();
    }

    @AfterEach
    void tearDown() {
        dRoot = null;
    }

    @ParameterizedTest
    @MethodSource("source")
    void Test1(int n, int expected) {
        int result = dRoot.digital_root(n);
        Assertions.assertEquals(expected, result);
    }
    @ParameterizedTest
    @MethodSource("source")
    void Test2(int n, int expected) {
        int result = dRoot.digital_root1(n);
        Assertions.assertEquals(expected, result);
    }
}