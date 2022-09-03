package codewars.sixkyu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PersistTest {
    Persist persist;

    @BeforeEach
    void setUp() {
        persist = new Persist();
    }

    @AfterEach
    void tearDown() {
        persist = null;
    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of(39, 3),
                Arguments.of(4, 0),
                Arguments.of(25, 2),
                Arguments.of(999, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void persistence(int value, int expected) {
        Assertions.assertEquals(expected, persist.persistence(value));
    }

    @ParameterizedTest
    @MethodSource("source")
    void persistence1(int value, int expected) {
        Assertions.assertEquals(expected, persist.persistence1(value));
    }
}