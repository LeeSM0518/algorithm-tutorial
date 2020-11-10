package greedy;

import java.util.Arrays;

public class _1이_될_때까지 {

  public int function1(String value1) {
    int[] arr = Arrays.stream(value1.split(" ")).mapToInt(Integer::parseInt).toArray();
    int N = arr[0];
    int K = arr[1];

    int count = 0;
    while (N > 1) {
      int rest = N % K;
      if (rest != 0) {
        count += (N > K) ? rest : rest - 1;
        N -= rest;
      } else {
        N /= K;
        count++;
      }
    }

    return count;
  }

  public int function2(String value1) {
    int[] arr = Arrays.stream(value1.split(" ")).mapToInt(Integer::parseInt).toArray();
    int N = arr[0];
    int K = arr[1];

    int count = 0;
    while (true) {
      // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
      int target = (N / K) * K;
      count += (N - target);
      N = target;
      if (N < K) break;
      // K로 나누기
      count += 1;
      N /= K;
    }

    // 마지막으로 남은 수에 대하여 1씩 빼기
    count += (N - 1);
    return count;
  }

  public static void main(String[] args) {
    _1이_될_때까지 obj = new _1이_될_때까지();

    String[] values1 = new String[]{"25 5", "26 5", "25 3"};
    String[] values2 = {"2", "3", "6"};

    long start = System.nanoTime();
    for (int i = 0; i < values1.length; i++) {
      if (Integer.parseInt(values2[i]) != obj.function1(values1[i])) {
        System.out.println("오답");
      }
    }
    long end = System.nanoTime();

    long result1 = end - start;
    System.out.println(result1);

    start = System.nanoTime();
    for (int i = 0; i < values1.length; i++) {
      if (Integer.parseInt(values2[i]) != obj.function2(values1[i])) {
        System.out.println("오답");
      }
    }
    end = System.nanoTime();

    long result2 = end - start;

    System.out.println(result1 / result2);
  }

}
