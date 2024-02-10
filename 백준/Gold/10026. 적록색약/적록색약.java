import java.util.*;
import java.io.*;


public class Main{
  static int n;
  static char[][] input; // 그림 입력값
  static int[][] visited; // 방문 구역 번호
  static Queue<int[]> queue = new LinkedList<>(); // 구역 내부 탐색 BFS 수행
  static char selectColor; // BFS 수행 조건


  // 상하좌우 탐색용
  static int[] dy = {-1, 1, 0, 0};
  static int[] dx = {0, 0, -1, 1};



  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    input = new char[n][n];
    visited = new int[n][n];
    // input 색칠
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < n; j++) {
        input[i][j] = s.charAt(j);
      }
    }

    // 색약 X
    int rgbCnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j] == 0) {
          selectColor = input[i][j];
          bfs(i, j, ++rgbCnt);
        }
      }
    }

    // 적록색약인 경우를 구하기 위해 G 를 R 로 변경 & visited 배열 0 으로 리셋
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        visited[i][j] = 0;
        if (input[i][j] == 'G') {
          input[i][j] = 'R';
        }
      }
    }

    // 색약 O
    int rbCnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j] == 0) {
          selectColor = input[i][j];
          bfs(i, j, ++rbCnt);
        }
      }
    }

    System.out.println(rgbCnt + " " + rbCnt);

  }

  private static void bfs(int y, int x, int cnt) {
    queue.clear();
    queue.add(new int[] {y, x});
    visited[y][x] = cnt;
    while (!queue.isEmpty()) { // 연결된 구역을 모두 방문하여 visited 를 업데이트하면 종료된다.
      int[] curArr = queue.poll();
      int curY = curArr[0];
      int curX = curArr[1];
      for (int i = 0; i < dx.length; i++) { // 상하좌우 탐색 시작
        int nextY = curY + dy[i];
        int nextX = curX + dx[i];
        if (!inner(nextY, nextX)) { // 범위를 벗어나면 continue
          continue;
        }
        // 상하좌우를 탐색하면서 같은 구역이라고 판단될 경우 큐에 해당 좌표를 추가하여 탐색을 예약한다.
        if (input[nextY][nextX] == selectColor && visited[nextY][nextX] == 0) {
          visited[nextY][nextX] = cnt;
          queue.add(new int[]{nextY, nextX}); // dfs라면 바로 탐색을 시작하겠지만 bfs 는 큐에 추가함으로써 현재 진행중인 탐색이 끝난뒤 수행한다.
        }
      }

    }
  }

  static boolean inner(int nextY, int nextX) { // 내부이면 true
    if (nextX < 0 || n <= nextX || nextY < 0 || nextY >= n) {
      return false;
    } else {
      return true;
    }
  }
}