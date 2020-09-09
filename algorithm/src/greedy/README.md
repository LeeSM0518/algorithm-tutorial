# Greedy(그리디)

* **Greedy(탐욕법)** : 현재 상황에서 가장 좋아 보이는 것만을 선택하는 알고리즘
  * 특정한 문제를 만났을 때 단순히 현재 상황에서 가장 좋아 보이는 것만을 선택해도 문제를 풀 수 있는지를 파악할 수 있어야 한다.
  * 그리디 알고리즘 문제라면 문제에서 **'가장 큰 순서대로', '가장 작은 순서대로' 와 같은 기준을 알게 모르게 제시해준다.**
  * 그리디 알고리즘 문제는 자주 **정렬 알고리즘과 짝을 이뤄 출제된다.**

<br>

## 문제1) 거스름돈

당신은 음식점의 계산을 도와주는 점원이다. 카운터에는 거스름돈으로 사용할 500원, 100원, 50원, 10원짜리 동전이 무한히 존재하다고 가정한다. 손님에게 거슬러 줘야 할 돈이 N원일 때 거슬러줘야 할 동전의 최소 개수를 구하라. 단, 거슬러 줘야 할 돈 N은 항상 10의 배수이다.

<br>

### 문제 해설

그리디 알고리즘 방식으로 풀려면 **'가장 큰 화폐 단위부터' 돈을 거슬러 주면 된다.**

* **내 코드**

  ```java
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
  ```

* **답안 코드**

  ```java
  public int function2(int price) {
    int count = 0;
    int[] coins = new int[]{500, 100, 50, 10};
  
    for (int coin : coins) {
      count += price / coin;
      price %= coin;
    }
  
    return count;
  }
  ```

<br>

화폐의 종류가 K개라고 할 때 위 소스 코드의 시간 복잡도는 **O(K)** 이다.

<br>

## 그리디 알고리즘의 정당성

그리디 알고리즘을 이용했을 때 '최적의 해'를 찾을 수 없을 가능성이 다분하지만, 탐욕적으로 문제에 접근했을 때 답을 찾을 수 있다는 보장이 있을 때는 매우 효과적이다.

거스름돈 문제를 그리디 알고리즘으로 해결할 수 있는 이유는 **가지고 있는 동전 중에서 큰 단위가 항상 작은 단위의 배수이므로 작은 단위의 동전들을 종합해 다른 해가 나올 수 없기 때문이다.**

대부분의 그리디 알고리즘 문제에서는 이처럼 문제 풀이를 위한 최소한의 아이디어를 떠올리고 **이것이 정당한지 검토할 수 있어야 답을 도출할 수 있다.**

<br>

## 문제2) 큰 수의 법칙

동빈이의 큰 수의 법칙은 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙이다.

단, 배열의 특정한 인덱스(번호)에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없는 것이 이 법칙의 특징이다.

예를 들어 순서대로 2, 4, 5, 4, 6 으로 이루어진 배열이 있을 때 M이 8이고, K가 3이라고 가정하자.

이 경우 특정한 인덱스의 수가 연속해서 세 번까지만 더해질 수 있으므로 큰 수의 법칙에 따른 결과는 6 + 6 + 6 + 5 + 6 + 6 + 6 + 5 인 46이 된다.

단, 서로 다른 인덱스에 해당하는 수가 같은 경우에도 서로 다른 것으로 간주한다. 예를 들어 순서대로 3, 4, 3, 4, 3 으로 이루어진 배열이 있을 때 M이 7이고, K가 2라고 가정하자. 이 경우 두 번째 원소에 해당하는 4와 네 번째 원소에 해당하는 4를 번갈아 두 번씩 더하는 것이 가능하다. 결과적으로 4 + 4 + 4 + 4 + 4 + 4 + 4 인 28이 도출된다.

배열의 크기 N, 숫자가 더해지는 횟수 M, 그리고 K 가 주어질 때 동빈이의 큰 수의 법칙에 따른 결과를 출력하시오.

* **입력 조건**

  * 첫재 줄에 N(2 <= N <= 1,000), M(1 <= M <= 10,000), K(1 <= k <= 10,000)의 자연수가 주어지며, 각 자연수는 공백으로 구분한다.
  * 둘째 줄에 N개의 자연수가 주어진다. 각 자연수는 공백으로 구분한다. 단, 각각의 자연수는 1 이상 10,000 이하의 수로 주어진다.
  * 입력으로 주어지는 K는 항상 M보다 작거나 같다.

* **출력 조건**

  * 첫째 줄에 동빈이의 큰 수의 법칙에 따라 더해진 답을 출력한다.

* **입력 예시**

  ```
  5 8 3
  2 4 5 4 6
  ```

* **출력 예시**

  ```
  46
  ```

<br>

### 문제 해설

* **내 코드**

  ```java
  public int function1(String values1, String values2) {
    int sum = 0;
    int[] conditionList = Arrays.stream(
      values1.split(" ")).mapToInt(Integer::valueOf).toArray();
    int[] valueList = Arrays.stream(
      values2.split(" ")).mapToInt(Integer::valueOf).toArray();
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
  
  public static void main(String[] args) {
    큰_수의_법칙 object = new 큰_수의_법칙();
  
    String values1 = "5 8 3";
    String values2 = "2 4 5 4 6";
  
    long start = System.nanoTime();
    System.out.println(object.function1(values1, values2));
    long end = System.nanoTime();
  
    System.out.println((end - start));
  }
  ```

  * 이와 같이 풀면 M의 크기가 100억 이상처럼 커진다면 시간 초과 판정을 받게 된다.
  * 이 문제를 풀려면 가장 먼저 **반복되는 수열에 대해서 파악해야** 한다.
  * 위의 예시에서는 수열 {6, 6, 6, 5} 가 반복된다.
  * 수열의 길이는 K + 1 로 4가 된다.
  * 따라서 M을 (K + 1)로 나눈 몫이 수열이 반복되는 횟수가 된다. 다시 여기에 K를 곱해주면 가장 큰 수가 등장하는 횟수가 된다. => (m / (k + 1)) * k = 6
  * 이때 M이 (K + 1)로 나누어떨어지지 않는 경우도 고려해야 한다.
  * 그럴 때는 M을 (K + 1)로 나눈 나머지만큼 가장 큰 수가 추가로 더해지므로 이를 고려해주어야 한다.
  * 결론, (M / (K + 1)) * K + M % (K + 1) 로 식이 완성된다.

* **해설 코드**

  ```java
  public int function2(String values1, String values2) {
    int[] conditionList = Arrays.stream(
      values1.split(" ")).mapToInt(Integer::valueOf).toArray();
    int[] valueList = Arrays.stream(
      values2.split(" ")).mapToInt(Integer::valueOf).toArray();
    
    
  
    int n = conditionList[0]; // 배열의 크기
    int m = conditionList[1]; // 숫자가 더해지는 횟수
    int k = conditionList[2]; // 연속으로 더할 수 있는 횟수
  
    Arrays.sort(valueList);
  
    int first = valueList[n - 1];
    int second = valueList[n - 2];
  
    int cnt = (m / (k + 1)) * k; // 수열 개수 * 가장 큰 값을 곱할 횟수
    cnt += m % (k + 1);          // 수열 개수로 나누어 떨어지지 않은 가장 큰 값의 횟수
  
    int sum = 0;
    sum += cnt * first;
    sum += (m - cnt) * second;
  
    return sum;
  }
  ```

  * 해설 코드로 짜면 내 코드보다 대략 7배 빠르다.

<br>

## 문제3) 숫자 카드 게임

숫자 카드 게임은 여러 개의 숫자 카드 중에서 가장 높은 숫자가 쓰인 카드 한 장을 뽑는 게임이다.

단, 게임의 룰을 지키며 카드를 뽑아야 하고 룰은 다음과 같다.

1. 숫자가 쓰인 카드들이 N x M 형태로 놓여 있다. 이때 **N은 행의 개수를** 의미하며, **M은 열의 개수를** 의미한다.
2. 먼저 뽑고자 하는 카드가 포함되어 있는 **행을 선택한다.**
3. 그다음 선택된 행에 포함된 카드들 중 **가장 숫자가 낮은 카드를 뽑아야 한다.**
4. 따라서 처음에 카드를 골라낼 행을 선택할 때, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여 최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.

* **입력 조건**

  * 첫째 줄에 숫자 카드들이 놓인 행의 개수 N과 열의 개수 M이 공백을 기준으로 하여 각각 자연수로 주어진다. ( 1 <= N, M <= 100 )
  * 둘째 줄부터 N개의 줄에 걸쳐 각 카드에 적힌 숫자가 주어진다. 각 숫자는 1 이상 10,000 이하의 자연수이다.

* **출력 조건**

  * 첫째 줄에 게임의 룰에 맞게 선택한 카드에 적힌 숫자를 출력한다.

* **입력 예시1**

  ```
  3 3
  3 1 2
  4 1 4
  2 2 2
  ```

* **출력 예시1**

  ```
  2
  ```

* **입력 예시2**

  ```
  2 4
  7 3 1 8
  3 3 3 4
  ```

* **출력 예시2**

  ```
  3
  ```

<br>

### 문제 해설

이 문제를 푸는 아이디어는 바로 **'각 행마다 가장 작은 수를 찾은 뒤에 그 수 중에서 가장 큰 수'를** 찾는 것이다.

<br>

* **내 코드**

  ```java
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
  }
  ```

* **해설 코드**

  ```java
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
  ```

  * 내 코드보다 약 3배 빠르다.

<br>

## 문제4) 1이 될 때까지

어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다. 단, 두 번째 연산은 N이 K로 나누어떨어질 때 만 선택할 수 있다.

1. N에서 1을 뺀다.
2. N을 K로 나눈다.

예를 들어 N이 17, K가 4라고 가정하자. 이때 1번의 과정을 한 번 수행하면 N은 16이 된다. 이후에 2번의 과정을 두 번 수행하면 N은 1이 된다. 결과적으로 이 경우 전체 과정을 실행한 횟수는 3이 된다. 이는 N을 1로 만드는 최소 횟수이다.

N과 K가 주어질 때 N이 1이 될 때 까지 1번 혹은 2번의 과정을 수행해야 하는 최소 횟수를 구하는 프로그램을 작성하시오.

* **입력 조건**

  * 첫째 줄에 N(2 <= N <= 100,000)과 K(2 <= K <= 100,000)가 공백으로 구분되며 각각 자연수로 주어진다. 이때 입력으로 주어지는 N은 항상 K보다 크거나 같다.

* **출력 조건**

  * 첫째 줄에 N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 횟수의 최솟값을 출력한다.

* **입력 예시**

  ```
  25 5
  ```

* **출력 예시**

  ```
  2
  ```

<br>

### 문제 해설

주어진 N에 대하여 **'최대한 많이 나누기'** 를 수행하면 된다.

1. N이 K의 배수가 될 때까지 1씩 빼기
2. N을 K로 나누기

* **ex) N = 25, K = 3**

  | 단계 | 처리  | N의 값 |
  | ---- | ----- | ------ |
  | 0    |       | 25     |
  | 1    | N - 1 | 24     |
  | 2    | N / K | 8      |
  | 3    | N - 1 | 7      |
  | 4    | N - 1 | 6      |
  | 5    | N / K | 2      |
  | 6    | N - 1 | 1      |

<br>

