# DFS/BFS

# 꼭 필요한 자료구조 기초

### 탐색(Search)

* 많은 양의 데이터 중에서 원하는 데이터를 찾는 과정이다.
* 그래프, 트리 등의 자료구조 안에서 탐색을 하는 문제를 주로 다룬다.
* 탐색 알고리즘으로 **DFS & BFS** 가 있다.

<br>

### 자료구조(Data Structure)

* 데이터를 표현하고 관리하고 처리하기 위한 구조

<br>

## 스택(Stack)

* 선입후출 또는 **후입선출(LIFO: Last In First Out)** 구조

<br>

## 큐(Queue)

* **선입선출(FIFO: First In First Out)** 구조

<br>

## 재귀 함수

* 자기 자신을 다시 호출하는 함수

* 팩토리얼 예제

  ```java
  public static long factorial(int n) {
    if (n <= 1)
      return 1;
    else
      return n * factorial(n - 1);
  }
  
  public static void main(String[] args) {
    long factorial = factorial(4);
    System.out.println(factorial);
  }
  
  // 결과 = 24
  ```
  * 재귀 함수가 수학의 점화식(재귀식)을 그대로 소스코드로 옮겼기 때문에 재귀 함수 코드가 간결한 것 이다.

  * 팩토리얼의 수학적 점화식

    ```
    n이 0혹은 1일 때: factorial(n) = 1
    n이 1보다 클 때:  factorial(n) = n * factorial(n - 1)
    ```

<br>

# 탐색 알고리즘 DFS/BFS

* **DFS(Depth-First Search)** : 깊이 우선 탐색. 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘이다.
* **그래프(Graph)의 기본 구조 **
  * **노드(Node) = 정점(Vertex)**
  * **간선(Edge)**
  * 두 노드가 간선으로 연결되어 있다 = 두 노드는 인접하다
* 프로그래밍에서 그래프는 크게 2가지 방식으로 표현할 수 있다.
  * **인접 행렬(Adjacency Matrix)** : 2차원 배열로 그래프의 연결 관계를 표현하는 방식
  * **인접 리스트(Adjacency List)** : 리스트로 그래프의 연결 관계를 표현하는 방식

<br>

### 인접 행렬(Adjacency Matrix) 방식

* 2차원 배열에 각 노드가 연결된 형태를 기록하는 방식이다.

  ```java
  int[][] arr = {
    {0, 1, 0},
    {1, 0, 1},
    {0, 1, 0}
  };
  ```

<br>

### 인접 리스트(Adjacency List) 방식

* 모든 노드에 연결된 노드에 대한 정보를 차례대로 연결하여 저장한다.

  ```java
  package dfs_bfs;
  
  import java.util.ArrayList;
  
  public class 인접_리스트 {
  
    static class Node {
      private int index;
      private int distance;
  
      public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
      }
  
      public void show() {
        System.out.println("(" + this.index + " , " + this.distance + ") ");
      }
    }
  
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  
    public static void main(String[] args) {
      for (int i = 0; i < 3; i++) {
        graph.add(new ArrayList<>());
      }
  
      graph.get(0).add(new Node(1, 7));
      graph.get(0).add(new Node(2, 5));
  
      graph.get(1).add(new Node(0, 7));
  
      graph.get(2).add(new Node(0, 5));
  
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < graph.get(i).size(); j++) {
          graph.get(i).get(j).show();
        }
        System.out.println();
      }
    }
  
  }
  ```

<br>

* 인접 행렬과 인접 리스트의 차이점은?
  * 메모리 측면
    * 인접 행렬 방식은 모든 관계를 저장하므로 노드 개수가 많을수록 메모리가 낭비된다.
    * 인접 리스트 방식은 연결된 정보만 저장하기 때문에 메모리를 효율적으로 사용한다.
  * 속도 측면
    * 인접 행렬 탐색 : O(1)
    * 인접 리스트 탐색 : O(n)

<br>

* DFS는 깊이 우선 탐색 알고리즘이다.

  * 이 알고리즘은 특정한 경로로 탐색하다가 특정한 상황에서 최대한 깊숙이 들어가서 노드를 방문한 후, 다시 돌아가 다른 경로를 탐색하는 알고리즘이다.

  * **구체적인 동작 과정**

    1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.
    2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문 처리를 한다. 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
    3. (2)번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.

    > `방문 처리` 는 스택에 한 번 삽입되어 처리된 노드가 다시 삽입되지 않게 체크하는 것을 의미한다. 방문 처리를 함으로써 각 노드를 한 번씩만 처리할 수 있다.