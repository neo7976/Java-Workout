package codewars.sevenkyu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class XOTest {

    XO xo;

    @BeforeEach
    void setUp() {
        xo = new XO();
        System.out.println("Начало теста");
    }

    @AfterEach
    void tearDown() {
        xo = null;
        System.out.println("Окончание теста");
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(true, "xxxooo"),
                Arguments.of(true, "xxxXooOo"),
                Arguments.of(false, "xxx23424esdsfvxXXOOooo"),
                Arguments.of(false, "xXxxoewrcoOoo"),
                Arguments.of(false, "XxxxooO"),
                Arguments.of(true, "zssddd"),
                Arguments.of(false, "Xxxxertr34")

        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void getXO_test(boolean expected, String str) {
        Assertions.assertEquals(expected, xo.getXO(str));
    }
}