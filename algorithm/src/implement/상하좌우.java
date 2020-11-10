package implement;

import greedy.거스름돈;

import java.util.Arrays;
import java.util.List;

public class 상하좌우 {

  public String function1(int size, String plan) {
    int x = 1;
    int y = 1;
    String[] list = plan.split(" ");
    for (String go : list) {
      switch (go) {
        case "L":
          x = (x > 1) ? x - 1 : 1;
          break;
        case "R":
          x = (x < size) ? x + 1 : size;
          break;
        case "U":
          y = (y > 1) ? y - 1 : 1;
          break;
        case "D":
          y = (y < size) ? y + 1 : size;
      }
    }
    return y + " " + x;
  }

  public String function2(int size, String plan) {
    int x = 1, y = 1;
    String[] list = plan.split(" ");

    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    char[] moveTypes = {'L', 'R', 'U', 'D'};

    for (int i = 0; i < list.length; i++) {
      char p = list[i].charAt(0);
      int nx = -1, ny = -1;
      for (int j = 0; j < 4; j++) {
        if (p == moveTypes[j]) {
          nx = x + dx[j];
          ny = y + dy[j];
        }
      }
      if (nx < 1 || ny < 1 || nx > size || ny > size) continue;
      x = nx;
      y = ny;
    }

    return x + " " + y;
  }

  public static void main(String[] args) {
    int[] size = {
        5, 3, 2
    };
    String[] plan = {
        "R R R U D D",
        "L U R U R R",
        "L U R R D D L L D U"
    };
    String[] result = {
        "3 4",
        "1 3",
        "1 1"
    };

    상하좌우 object = new 상하좌우();

    long start = System.nanoTime();
    for (int i = 0; i < size.length; i++) {
      if (!object.function1(size[i], plan[i]).equals(result[i]))
        System.out.println("오답");
    }
    long end = System.nanoTime();

    long result1 = end - start;

    start = System.nanoTime();
    for (int i = 0; i < size.length; i++) {
      if (!object.function2(size[i], plan[i]).equals(result[i]))
        System.out.println("오답");
    }
    end = System.nanoTime();

    long result2 = end - start;

    System.out.println(result1 / result2);
  }

}
