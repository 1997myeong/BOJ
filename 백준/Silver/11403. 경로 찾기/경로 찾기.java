import java.util.*;
import java.io.*;


public class Main{
  static int node;
  static int[][] edge;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    node = Integer.parseInt(br.readLine());
    edge = new int[node][node];

    // 주어진 간선 정보를 edge 배열에 넣는다
    for (int i = 0; i < node; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < node; j++) {
        edge[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < node; i++) { // 노드 시작점
      visited = new boolean[node]; // 시작점이 변경될때 리셋
      for (int j = 0; j < node; j++) { // 노드 도착점
        if (edge[i][j] == 1 && !visited[j]) {
          bfs(i, j);
        }
      }

    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < node; i++) {
      for (int j = 0; j < node; j++) {
        sb.append(edge[i][j] + " ");
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());



  }

  // 너비우선 탐색
  private static void bfs(int x, int y) { // 연결되어있는 x와 y가 들어온다.
    Queue<Integer> q = new LinkedList<>();
    q.add(y); // x와 연결되어있는 y값을 q에 add 해준다.
    while (!q.isEmpty()) {
      int number = q.poll();
      for (int i = 0; i < node; i++) {
        if (!visited[i] && edge[number][i] == 1) { // 방문하지 않았고, q에서 빠진수가 i를 가르킨다면
          q.add(i); // i를 q에 넣어준다. (bfs)
          visited[i] = true;
          edge[x][i] = 1; // x가 가르키는 수는 q에 넣었고 q에서 빠진 수가 i를 가르키기때문에  x -> i 경로는 존재한다.
        }
      }
    }

  }
}