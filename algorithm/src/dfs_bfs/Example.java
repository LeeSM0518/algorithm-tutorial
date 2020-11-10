package dfs_bfs;

public class Example {

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

}
