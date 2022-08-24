package easy.roman;

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

class RomanTest {
    Roman romanAlphabet;

    @BeforeEach
    void setUp() {
        System.out.println("Начало теста");
        romanAlphabet = new Roman();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Окончание теста");
        romanAlphabet = null;
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(1, "I"),
                Arguments.of(5, "V"),
                Arguments.of(10, "X"),
                Arguments.of(50, "L"),
                Arguments.of(100, "C"),
                Arguments.of(500, "D"),
                Arguments.of(4, "IV"),
                Arguments.of(9, "IX"),
                Arguments.of(40, "XL"),
                Arguments.of(90, "XC"),
                Arguments.of(400, "CD"),
                Arguments.of(900, "CM"),
                Arguments.of(1000, "M"),
                Arguments.of(58, "LVIII"),
                Arguments.of(1994, "MCMXCIV")
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void arabToRoman(int value, String expected) throws NotValidateException {
        String result = romanAlphabet.arabToRoman(value);
        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }

    @Test
    void validate_test() {
        Assertions.assertThrows(NotValidateException.class, () -> romanAlphabet.validate(4000));
        Assertions.assertDoesNotThrow(() -> romanAlphabet.validate(1000));
    }
}