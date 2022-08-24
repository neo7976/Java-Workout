package Easy.Roman13;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AlfaTest {
    Alfa alfa;

    @BeforeEach
    void setUp() {
        System.out.println("Начало теста");
        alfa = new Alfa();
    }

    @AfterEach
    void tearDown() {
        System.out.println("\nКонец теста");
        alfa = null;
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of("II", 2),
                Arguments.of("I", 1),
                Arguments.of("III", 3),
                Arguments.of("IV", 4),
                Arguments.of("V", 5),
                Arguments.of("VI", 6),
                Arguments.of("IX", 9),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void romanToInteger(String s, int x) throws NotValidateException {
        int result = alfa.romanToInteger(s);
        MatcherAssert.assertThat(result, Matchers.equalTo(x));
    }

    @Test
    void validate_test() {
        Assertions.assertThrows(NotValidateException.class, () -> alfa.validate(4000));
    }
}
