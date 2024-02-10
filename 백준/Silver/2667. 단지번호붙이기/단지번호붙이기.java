import java.util.*;
import java.io.*;


public class Main{

  static int node;
  static int[][] matrix;
  static boolean[][] visited;



  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    node = Integer.parseInt(br.readLine());

    matrix = new int[node + 1][node + 1];
    visited = new boolean[node + 1][node + 1];


    // 주어진 배열 생성
    for (int i = 0; i < node; i++) {
      String[] sArr = br.readLine().split("");
      for (int j = 0; j < node; j++) {
        matrix[i + 1][j + 1] = Integer.parseInt(sArr[j]);
      }
    }

    int bfsCount = 0;
    ArrayList<Integer> arr = new ArrayList<>();
    int total = 0;
    for (int i = 1; i <= node; i++) {
      for (int j = 1; j <= node; j++) {
        if (!visited[i][j] && matrix[i][j] == 1) {
          arr.add(bfs(i, j));

          total++;
        }
      }
    }



    // 요구하는 값으로 정렬하여 출력한다.
    System.out.println(total);
    Collections.sort(arr);
    for (int bfscnt : arr) {
      System.out.println(bfscnt);
    }

  }

  // 상하좌우 탐색할 x, y 증가량 배열
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};



  static int bfs(int a, int b) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {a, b});
    int cnt = 1; // 단지내 집 수이다. 처음 큐에 들어온 집을 카운트 해줘야한다.
    while (!q.isEmpty()) { //
      int[] arr = q.poll();
      int cx = arr[0];
      int cy = arr[1];
      visited[cx][cy] = true; // 방문 처리
      
      for (int i = 0; i < dx.length; i++) {
        int nx = dx[i] + cx; // 다음 탐색할 자리
        int ny = dy[i] + cy; // 다음 탐색할 자리
        if (!inner(nx, ny)) { // 내부 에 존재하는지 알아보는 로직
          continue;
        }
        if (matrix[nx][ny] == 1 && !visited[nx][ny]) { // 방문하지않은 & 다음 순서에 집이 있는 경우
          q.add(new int[] {nx, ny}); // bfs
          visited[nx][ny] = true; // 방문 처리
          cnt++; // 탐색 할 때마다 단지내 집 수 카운트 해준다.
        }

      }

    }
    return cnt;

  }
  static boolean inner(int a, int b) {
    if (a > node || b > node || a < 0 || b < 0) {
      return false;
    } else {
      return true;
    }
  }
}