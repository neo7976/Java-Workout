package youtube.yandex.door;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainDoor {
    public static void main(String[] args) {

        boolean[] door = new boolean[100];

        System.out.println("До начала итераций:" + Arrays.toString(door));
        int j = 1;
        while (j <= door.length) {
            for (int i = 0; i < door.length; i++) {
                if ((i + 1) % j == 0)
                    door[i] = !door[i];
            }
            j++;
        }

        for (int i = 0; i < door.length; i++) {
            if (door[i])
                System.out.printf("Дверь №%d открыта!\n", i + 1);
        }
    }
}
