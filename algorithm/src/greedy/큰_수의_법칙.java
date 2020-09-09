package greedy;

import java.util.Arrays;

public class 큰_수의_법칙 {

  public int function1(String values1, String values2) {
    int sum = 0;
    int[] conditionList = Arrays.stream(values1.split(" ")).mapToInt(Integer::valueOf).toArray();
    int[] valueList = Arrays.stream(values2.split(" ")).mapToInt(Integer::valueOf).toArray();
    int available = conditionList[2];
    int index = valueList.length - 1;
    Arrays.sort(valueList);
    for (int i = 0; i < conditionList[1]; i++) {
      if (available == 0) {
        sum += valueList[index - 1];
        available = conditionList[2];
      } else {
        sum += valueList[index];
        available--;
      }
    }
    return sum;
  }

  public int function2(String values1, String values2) {
    int[] conditionList = Arrays.stream(values1.split(" ")).mapToInt(Integer::valueOf).toArray();
    int[] valueList = Arrays.stream(values2.split(" ")).mapToInt(Integer::valueOf).toArray();

    int n = conditionList[0]; // 배열의 크기
    int m = conditionList[1]; // 숫자가 더해지는 횟수
    int k = conditionList[2]; // 연속으로 더할 수 있는 횟수

    Arrays.sort(valueList);

    int first = valueList[n - 1];
    int second = valueList[n - 2];

    int cnt = (m / (k + 1)) * k;
    cnt += m % (k + 1);

    int sum = 0;
    sum += cnt * first;
    sum += (m - cnt) * second;

    return sum;
  }

  public static void main(String[] args) {
    큰_수의_법칙 object = new 큰_수의_법칙();

    String values1 = "5 8 3";
    String values2 = "2 4 5 4 6";

    long start = System.nanoTime();
    System.out.println(object.function1(values1, values2));
    long end = System.nanoTime();

    long result1 = end - start;

    start = System.nanoTime();
    System.out.println(object.function2(values1, values2));
    end = System.nanoTime();

    long result2 = end - start;

    System.out.println(result1 / result2);
  }

}
