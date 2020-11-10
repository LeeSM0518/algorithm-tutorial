package implement;

public class 시각 {

  public int function1(int hour) {
    if (hour < 3) return (hour + 1) * 1575;
    else if (hour < 13) return hour * 1575 + 3600;
    else if (hour < 23) return (hour - 1) * 1575 + 3600 * 2;
    else return (hour - 2) * 1575 + 3600 * 3;
  }

  public int function2(int hour) {
    int count = 0;

    for (int i = 0; i <= hour; i++) {
      for (int j = 0; j < 60; j++) {
        for (int k = 0; k < 60; k++) {
          if (i % 10 == 3 || j / 10 == 3 || j % 10 == 3 || k / 10 == 3 || k % 10 == 3) {
            count++;
          }
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int size = 5;
    int result = 11475;

    시각 object = new 시각();

    long start = System.nanoTime();
    if (object.function1(size) != result)
      System.out.println("오답");
    long end = System.nanoTime();

    long result1 = end - start;

    start = System.nanoTime();
    if (object.function2(size) != result)
      System.out.println("오답");
    end = System.nanoTime();

    long result2 = end - start;

    System.out.println(result2 / result1);
  }

}
