import java.util.*;
import java.io.*;


public class Main{

  static int[][] matrix;
  static boolean[][] visited;

  static int[][] location;

  static int a;
  static int b;



  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    matrix = new int[a + 1][b + 1];
    location = new int[a + 1][b + 1];
    visited = new boolean[a + 1][b + 1];


    // 주어진 배열 생성
    for (int i = 0; i < a; i++) {
      String[] sArr = br.readLine().split("");
      for (int j = 0; j < b; j++) {
        matrix[i + 1][j + 1] = Integer.parseInt(sArr[j]);
      }
    }

    ArrayList<Integer> arr = new ArrayList<>();
    int total = 0;
    
    // 시작위치
    bfs(1, 1);


    System.out.println(location[a][b]);

  }

  // 상하좌우 탐색할 x, y 증가량 배열
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};



  static void bfs(int a, int b) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {a, b});
    location[a][b] = 1; // 들어온 위치부터 1
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
          location[nx][ny] = location[cx][cy] + 1; // 다음 위치 = 이전 위치 + 1
        }

      }

    }

  }
  static boolean inner(int x, int y) {
    if (x > a || y > b || x < 0 || y < 0) {
      return false;
    } else {
      return true;
    }
  }



}