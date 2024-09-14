import java.io.*;
import java.util.*;
 
class PrimePath {
  private int V;
  private LinkedList<Integer>[] PrimeList;
 
  
  @SuppressWarnings("unchecked") PrimePath(int v)
  {
    V = v;
    PrimeList = new LinkedList[v];
    for (int i = 0; i < v; i++)
      PrimeList[i] = new LinkedList<Integer>();
  }
 
  void addedge(int V1, int V2)
  {
    PrimeList[V1].add(V2);
    PrimeList[V2].add(V1);
  }
 
  static void filter(LinkedList<Integer> v)
  {
    int n = 9999;
    Boolean prime[] = new Boolean[n + 1];
    Arrays.fill(prime, true);
    for (int p = 2; p * p <= n; p++) {
 
      
      if (prime[p] == true) {
 
        
        for (int i = p * p; i <= n; i += p)
          prime[i] = false;
      }
    }
 
    for (int p = 1000; p <= n; p++) {
      if (prime[p])
        v.add(p);
    }
  }
  int bfs(int a, int b)
  {
    int visited[] = new int[V];
    Arrays.fill(visited, 0);
    Queue<Integer> que = new LinkedList<Integer>();
    visited[a] = 1;
    que.add(a);
 
    while (!que.isEmpty()) {
      int p = que.poll();
      for (int i : PrimeList[p]) {
        if (visited[i] == 0) {
          visited[i] = visited[p] + 1;
          que.add(i);
        }
        if (i == b) {
          return visited[i] - 1;
        }
      }
    }
 
    return 0;
  }
 
  
  static Boolean compare(int num1, int num2)
  {
    char[] s1 = (Integer.toString(num1)).toCharArray();
    char[] s2 = (Integer.toString(num2)).toCharArray();
    int c = 0;
    if (s1[0] != s2[0])
      c++;
    if (s1[1] != s2[1])
      c++;
    if (s1[2] != s2[2])
      c++;
    if (s1[3] != s2[3])
      c++;
 
    
    return (c == 1);
  }
 
  static int shortestPath(int num1, int num2)
  {
    
    LinkedList<Integer> primes = new LinkedList<Integer>();
    filter(primes);
 
    
    PrimePath g = new PrimePath(primes.size());
    for (int i = 0; i < primes.size(); i++) {
      for (int j = i + 1; j < primes.size(); j++) {
        if (compare(primes.get(i), primes.get(j)))
          g.addedge(i, j);
      }
    }
 
    int a = 0, b = 0;
    for (int j = 0; j < primes.size(); j++) {
      if (primes.get(j) == num1)
        a = j;
    }
 
    for (int j = 0; j < primes.size(); j++) {
      if (primes.get(j) == num2)
        b = j;
    }
 
    return g.bfs(a, b);
  }
 
  public static void main(String[] args)
  {
    Scanner reader = new Scanner(System.in);;
    System.out.println("Input: ");
    String PrimeOne = reader.nextLine();
    int num1=Integer.parseInt(PrimeOne);
    String PrimeTwo = reader.next();
    int num2=Integer.parseInt(PrimeTwo);
    System.out.println("Output: ");
    int steps = shortestPath(num1, num2);
    System.out.print(steps);
  }
}
 
