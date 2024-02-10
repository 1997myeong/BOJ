import java.util.*;
import java.io.*;


public class Main{
  static int n;
  static int m;
  static int[][] input; // 색칠 공간 입력값
  static int[][] visited; // 방문 구역 번호
  static Queue<int[]> queue = new LinkedList<>(); // 구역 내부 탐색 BFS 수행 (x, y) 좌표값

  static StringBuilder sb = new StringBuilder();

  static ArrayList<Integer> result = new ArrayList<>();

  static int area;

  // 상하좌우 탐색용
  static int[] dy = {-1, 1, 0, 0};
  static int[] dx = {0, 0, -1, 1};



  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer firstLine = new StringTokenizer(br.readLine());

    m = Integer.parseInt(firstLine.nextToken());
    n = Integer.parseInt(firstLine.nextToken());
    int k = Integer.parseInt(firstLine.nextToken());

    input = new int[n][m];
    visited = new int[n][m];

    // 좌표와 2차원 배열은 방향이 다르지만 구조는 똑같다.
    for (int i = 0; i < k; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int preX = Integer.parseInt(st.nextToken());
      int preY = Integer.parseInt(st.nextToken());
      int curX = Integer.parseInt(st.nextToken());
      int curY = Integer.parseInt(st.nextToken());
      for (int j = preX; j < curX; j++) {
        for (int l = preY; l < curY; l++) {
          input[j][l] = 1; // 색칠된 부분을 1 로 대입
        }
      }
    }


    // 방문하지 않았고, 색칠이 안된부분을 탐색한다.
    int cnt = 0; // 빈 공간 덩어리의 수
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (visited[i][j] == 0 && input[i][j] == 0) {

          int blankArea = bfs(i, j);
          result.add(blankArea);
          cnt++;
        }
      }
    }


    
    System.out.println(cnt);
    
    // 오름차순 정렬 후 출력
    Collections.sort(result);
    for (int i = 0; i < result.size(); i++) {
      sb.append(result.get(i) + " ");
    }
    System.out.println(sb.toString());


  }




  // 빈공간의 넓이를 리턴한다.
  private static int bfs(int x, int y) {

    queue.clear();
    queue.add(new int[] {x, y});
    visited[x][y] = 1;
    area = 1;

    while (!queue.isEmpty()) {
      int[] curArr = queue.poll();
      int curX = curArr[0];
      int curY = curArr[1];
      for (int i = 0; i < dx.length; i++) {
        int nextX = dx[i] + curX;
        int nextY = dy[i] + curY;
        if (!inner(nextY, nextX)) {
          continue;
        }
        // 상하좌우중 해당하는 값이 색칠이 안되어있고 방문하지 않았다면 큐에 추가한다. (bfs)
        if (input[nextX][nextY] == 0 && visited[nextX][nextY] == 0) {
          visited[nextX][nextY] = 1;
          queue.add(new int[]{nextX, nextY});
          area++;
        }
      }
    }
    return area;


  }

  // 내부에 존재하는지 검증하는 로직
  static boolean inner(int x, int y) {
    if (x >= m || x < 0 || y >= n || y < 0) {
      return false;
    } else {
      return true;
    }
  }
}