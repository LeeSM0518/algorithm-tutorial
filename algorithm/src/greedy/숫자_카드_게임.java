package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 숫자_카드_게임 {

  public int function1(String values1, String[][] values2) {
    List<TreeSet<Integer>> treeSetList = new ArrayList<>();
    for (String[] valueList : values2) {
      for (String valueStr : valueList) {
        treeSetList.add(
            Arrays.stream(valueStr.split(" "))
            .map(Integer::valueOf)
            .collect(Collectors.toCollection(TreeSet::new)));
      }
    }
    return treeSetList.stream().map(TreeSet::first).max(Integer::compareTo).get();
  }

  public int function2(String values1, String[][] values2) {
    int result = 0;

    for (String[] valueList : values2) {
      for (String valueStr : valueList) {
        List<Integer> collect = Arrays.stream(valueStr.split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
        int minValue = 10001;
        for (Integer value : collect) {
          minValue = Math.min(minValue, value);
        }
        result = Math.max(result, minValue);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    숫자_카드_게임 obj = new 숫자_카드_게임();

    String[] values1 = new String[]{"3 3", "2 4"};
    String[][][] values2 = {
        {
            {"3 1 2"},
            {"4 1 4"},
            {"2 2 2"}
        },
        {
            {"7 3 1 8"},
            {"3 3 3 4"}
        }
    };

    long start = System.nanoTime();
    for (int i = 0; i < values1.length; i++) {
      System.out.println(obj.function1(values1[i], values2[i]));
    }
    long end = System.nanoTime();

    long result1 = end - start;
    System.out.println(result1);

    start = System.nanoTime();
    for (int i = 0; i < values1.length; i++) {
      System.out.println(obj.function2(values1[i], values2[i]));
    }
    end = System.nanoTime();

    long result2 = end - start;

    System.out.println(result1 / result2);
  }

}
