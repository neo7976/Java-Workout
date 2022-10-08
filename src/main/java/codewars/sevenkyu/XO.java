package codewars.sevenkyu;

import java.util.Arrays;


public class XO {

    public boolean getXO(String str) {
        // Good Luck!!
        int x = (int) Arrays.stream(str.toLowerCase().split("")).filter(y -> y.equals("x")).count();
        int o = (int) Arrays.stream(str.toLowerCase().split("")).filter(y -> y.equals("o")).count();
        return x == o;
    }

    public boolean getXO1(String str) {
        int countX = (int) str.toLowerCase().chars().filter(ch -> ch == 'x').count();
        int countO = (int) str.toLowerCase().chars().filter(ch -> ch == 'o').count();

        return countX == countO;
    }
}