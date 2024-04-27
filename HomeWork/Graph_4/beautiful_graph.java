package HomeWork.Graph_4;

import java.io.*;
import java.util.*;

class Main {
  final static int MOD = 998244353;
  static int[] pow2 = new int[300001];
  public static void builPow() {
    pow2[0] = 1;
    for (int i = 1; i < 300001; i++) {
      pow2[i] = ((pow2[i - 1] % MOD) * 2) % MOD;
    }
  }
  public static void main(String[] args) {
    try {
      System.setIn(new FileInputStream("input.txt"));
      System.setOut(new PrintStream(new FileOutputStream("output.txt")));
    } catch (Exception e) {
      System.err.println("Error");
    }

    Scanner sc = new Scanner(System.in);
    builPow();
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      List<List<Integer>> adj = new ArrayList<>();
      for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
      for (int i = 0; i < m; i++) {
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        adj.get(v1).add(v2);
        adj.get(v2).add(v1);
      }

      Queue<Integer> q = new LinkedList<>();
      int[] vis = new int[n + 1];
      boolean isAnswerZero = false;
      long ans = 1;
      for (int i = 1; i <= n; i++) {
        if (vis[i] == 0) {
          q.offer(i);
          vis[i] = 1;
          int tmp1 = 1;
          int tmp2 = 0;
          while (!q.isEmpty() && !isAnswerZero) {
            int size = q.size();
            while (size-- > 0 && !isAnswerZero) {
              int curr = q.poll();
              for (int neigh : adj.get(curr)) {
                if (vis[neigh] != 0 && vis[neigh] % 2 == vis[curr] % 2) {
                  System.out.println(0);
                  i = n;
                  isAnswerZero = true;
                  break;
                } else if (vis[neigh] == 0) {
                  if (vis[curr] == 1) {
                    vis[neigh] = 2;
                    tmp2++;
                  } else {
                    vis[neigh] = 1;
                    tmp1++;
                  }
                  q.add(neigh);
                }
              }
            }
          }
          // System.out.println(tmp1+" "+tmp2);
          ans = ((ans % MOD) * ((pow2[tmp1] + pow2[tmp2]) % MOD)) % MOD;
        }
      }

      if (!isAnswerZero) {
        System.out.println(ans);
      }
    }

    sc.close();
  }
}

public class beautiful_graph {}
