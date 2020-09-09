package complexity;

public class BigO {

  public static void main(String[] args) {
    int[] array = new int[]{3, 5, 1, 2, 4};
    int sum = 0;

    for (int j = 0; j < array.length; j++) {
      for (int i = 0; i < array.length; i++) {
        sum += array[i] * array[j];
      }
    }

    System.out.println(sum);
  }

}