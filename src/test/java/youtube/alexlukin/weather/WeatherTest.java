package youtube.alexlukin.weather;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class WeatherTest {
    Weather weather;

    @BeforeEach
    void setUp() {
        weather = new Weather();
    }

    @AfterEach
    void tearDown() {
        weather = null;
    }

    @Test
    void findSunnyDay_test() {
        int[] expected = new int[]{
                2, 1, 4, 2, 1, 1, 0
        };
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(weather.findSunnyDay(new int[]{13, 12, 15, 11, 9, 12, 16})));
    }

    @Test
    void findSunnyDayForStack_test() {
        int[] expected = new int[]{
                2, 1, 4, 2, 1, 1, 0
        };
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(weather.findSunnyDayForStack(new int[]{13, 12, 15, 11, 9, 12, 16})));
    }
}