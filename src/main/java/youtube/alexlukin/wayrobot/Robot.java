package youtube.alexlukin.wayrobot;

public class Robot {

    private final char ROBOT = 'R';
    private final char DOOR = 'D';
    private final char X = '-';

    public void printMatrix(int n, int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == m - 1 && j == n - 1)
                    System.out.printf("[ %c ]", DOOR);
                else if (i == 0 && j == 0)
                    System.out.printf("[ %c ]", ROBOT);
                else
                    System.out.printf("[ %c ]", X);
            }
            System.out.println();
        }
    }

    public int paths(int n, int m) {
        printMatrix(n, m);
        return helper(n, m, new int[n + 1][m + 1]);
    }

    public int helper(int n, int m, int[][] arr) {
        if (n < 1 || m < 1)
            return 0;
        if (n == 1 && m == 1)
            return 1;
        if (arr[n][m] != 0)
            return arr[n][m];
        arr[n][m] = helper(n - 1, m, arr) + helper(n, m - 1, arr);
        return arr[n][m];
    }

    public static void main(String[] args) {
        Robot robot = new Robot();
        System.out.println(robot.paths(3, 3));
    }
}
