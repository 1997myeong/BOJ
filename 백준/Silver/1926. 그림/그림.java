import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] matrix;
    static int[][] visited;
    static int n;
    static int m;
    static int count = 0; // 그림의 갯수
    static int largest = 0; // 가장 큰 그림의 크기
    static int area = 0; // 그림의 크기

    static Queue<int[]> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로크기 행을 의미
        m = Integer.parseInt(st.nextToken()); // 가로크기 열을 의미



        matrix = new int[n + 1][m + 1];
        visited = new int[n + 1][m + 1];




        for (int i = 1; i <= n; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (visited[i][j] == 0 && matrix[i][j] == 1) {
                    bfs(i, j);
                    count++;
                    largest = Math.max(largest, area);
                    area = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count);
        sb.append("\n");
        sb.append(largest);

        System.out.println(sb);


    }
    static int[] x = {-1, 1, 0, 0};
    static int[] y = {0, 0, 1, -1};
    static void bfs(int a, int b) {
        q.add(new int[]{a, b});
        visited[a][b] = 1;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            area++;
            int cx = poll[0];
            int cy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + x[i];
                int ny = cy + y[i];
                if (inner(nx, ny) && visited[nx][ny] == 0 && matrix[nx][ny] == 1) {
                    visited[nx][ny] = 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    static boolean inner(int a, int b) {
        if (a > n || a < 0 || b > m || b < 0) {
            return false;
        } else {
            return true;
        }
    }
}
