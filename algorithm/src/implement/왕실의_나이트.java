package implement;

public class 왕실의_나이트 {

  public int function1(String hour) {
    String[] split = hour.split("");

    int x = 0, y = Integer.parseInt(split[1]), count = 0;

    int[] goX = {-1, 1, 2, 2, 1, -1, -2, -2};
    int[] goY = {-2, -2, -1, 1, 2, 2, 1, -1};

    switch (split[0]) {
      case "a": x = 1; break;
      case "b": x = 2; break;
      case "c": x = 3; break;
      case "d": x = 4; break;
      case "e": x = 5; break;
      case "f": x = 6; break;
      case "g": x = 7; break;
      case "h": x = 8; break;
    }

    for (int i = 0; i < goX.length; i++) {
      int resultX = x + goX[i];
      int resultY = y + goY[i];
      if (resultX < 1 || resultX > 8 || resultY < 1 || resultY > 8) continue;
      count++;
    }

    return count;
  }

  public static void main(String[] args) {
    String[] point = {"a1", "h8", "d4", "h1", "a8", "a5"};
    int[] result = {2, 2, 8, 2, 2, 4};

    왕실의_나이트 object = new 왕실의_나이트();

    long start = System.nanoTime();
    for (int i = 0; i < point.length; i++) {
      if (object.function1(point[i]) != result[i])
        System.out.println("오답");
    }
    long end = System.nanoTime();

    long result1 = end - start;

//    start = System.nanoTime();
//    if (object.function2(size) != result)
//      System.out.println("오답");
//    end = System.nanoTime();
//
//    long result2 = end - start;
//
//    System.out.println(result2 / result1);
  }

}
