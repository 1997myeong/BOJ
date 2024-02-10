import java.util.*;
import java.io.*;


public class Main{

  static int node;
  static int[][] edge;
  static boolean[] visited;


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    node = Integer.parseInt(br.readLine());
    int cnt = Integer.parseInt(br.readLine());
    edge = new int[node + 1][node + 1];
    visited = new boolean[node + 1];
    for (int i = 0; i < cnt; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      edge[a][b] = edge[b][a] = 1; // 연결된 컴퓨터
    }


    if (node == 1) { // 컴퓨터가 한 대일 경우
      System.out.println(0);
    } else {
      System.out.println(bfs(1) - 1); // 1번 컴퓨터는 제외

    }


  }

  //
  private static int bfs(int x) {
    Queue<Integer> q = new LinkedList<>();
    q.add(x); // 탐색할 노드를 q 에 add.
    int cnt = 0; // 바이러스에 걸리게 되는 컴퓨터의 숫자
    while (!q.isEmpty()) {
      int number = q.poll();
      for (int j = 1; j < edge.length; j++) { //
        if (edge[number][j] == 1 && !visited[j]) { // 연결되어있으면서 탐색하지 않은 노드를 찾는다
          visited[j] = true;
          q.add(j);
          cnt++;
        }
      }

    }
    return cnt;
  }
}