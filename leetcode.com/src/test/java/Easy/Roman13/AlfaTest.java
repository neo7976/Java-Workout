package Easy.Roman13;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
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
        return Stream.of(Arguments.of("I", 1),
                Arguments.of("II", 2),
                Arguments.of("III", 3),
                Arguments.of("IV", 4),
                Arguments.of("V", 5),
                Arguments.of("VI", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void romanToInteger(String s, int x) {

        int result = alfa.romanToInteger(s);
        MatcherAssert.assertThat(x, Matchers.equalTo(result));
    }

    @Test
    void dfgfg(){

    }
}
