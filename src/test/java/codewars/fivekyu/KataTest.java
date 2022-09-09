package codewars.fivekyu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
    Kata kata;

    @BeforeEach
    void setUp() {
        kata = new Kata();
    }

    @AfterEach
    void tearDown() {
        kata = null;
    }

    private void doTest(String str, String expected) {
        assertEquals(expected, kata.incrementString(str), "input: <"+str+">");
    }

    @Test
    public void exampleTests() {
        doTest("foobar099", "foobar100");
        doTest("foo", "foo1");
        doTest("foobar001", "foobar002");
        doTest("foobar99", "foobar100");
        doTest("foobar099", "foobar100");
        doTest("", "1");
    }
}