import java.util.*;
import java.io.*;


public class Main{

  static int node;
  static int[][] edge;
  static boolean[] visited;


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    node = Integer.parseInt(st.nextToken());
    int cnt = Integer.parseInt(st.nextToken());

    edge = new int[node + 1][node + 1]; // 간선 정보를 넣을 2차원배열

    //
    visited = new boolean[node + 1]; // 노드 방문 여부를 확인할 boolean 배열
    for (int i = 0; i < cnt; i++) {
      StringTokenizer line = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(line.nextToken());
      int b = Integer.parseInt(line.nextToken());

      edge[a][b] = edge[b][a] = 1;
    }

    int result = 0; // 연결 요소 갯수
    for (int i = 1; i <= node; i++) {
      if (!visited[i]) {
        bfs(i);

        // 윗 줄의 bfs(i)에서 연결되어있는 노드를 전부 탐색하고 빠져나오기 때문에
        // 이곳에서 요소의 갯수를 카운트 할 수 있다.
        result++;

      }
    }

    System.out.println(result);
  }

  private static void bfs(int i) { // 방문하지 않은 노드 i
    Queue<Integer> q = new LinkedList();
    q.add(i);
    while (!q.isEmpty()) {
      int num = q.poll();
      for (int j = 1; j <= node; j++) {
        if (!visited[j] && edge[num][j] == 1) { // 방문하지 않았고, num과 j가 연결되어있다면
          q.add(j); // q 에 j 노드를 추가한다.
          visited[j] = true; // j 노드를 q에 추가했으니 방문 처리한다.
        }
      }
    }
  }
}