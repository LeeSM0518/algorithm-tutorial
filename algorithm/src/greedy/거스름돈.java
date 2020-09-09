package greedy;

public class 거스름돈 {

  public int function1(int price) {
    int count = 0;
    int[] moneyList = new int[]{500, 100, 50, 10};

    for (int money : moneyList) {
      if (price >= money) {
        int value = price / money;
        count += value;
        price -= money * value;
      }
    }

    return count;
  }

  public int function2(int price) {
    int count = 0;
    int[] coins = new int[]{500, 100, 50, 10};

    for (int coin : coins) {
      count += price / coin;
      price %= coin;
    }

    return count;
  }

  public static void main(String[] args) {
    int[] price = {0, 10, 20, 50, 60, 100, 150, 160, 110, 500, 600, 650, 550, 510, 1460};
    int[] result = {0, 1, 2, 1, 2, 1, 2, 3, 2, 1, 2, 3, 2, 2, 8};

    거스름돈 object = new 거스름돈();

    long start = System.nanoTime();
    for (int i = 0; i < price.length; i++) {
      if (object.function1(price[i]) != result[i])
        System.out.println("오답");
    }
    long end = System.nanoTime();

    System.out.println("소요 시간: " + (end - start));

    start = System.nanoTime();
    for (int i = 0; i < price.length; i++) {
      if (object.function2(price[i]) != result[i])
        System.out.println("오답");
    }
    end = System.nanoTime();

    System.out.println("소요 시간: " + (end - start));

  }

}
