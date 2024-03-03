import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[][] matrix;
    static boolean[][] visited;
    static int size;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        size = N;
        matrix = new int[N + 1][N + 1];

        int max = 0;
        for (int i = 0; i < N; i++) { // 행
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) { // 열
                matrix[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(matrix[i][j], max);
            }
        }

        int result = 0;

        for (int i = 0; i < max; i++) {
            visited = new boolean[N + 1][N + 1];

            for (int j = 0; j < N; j++) {
                for (int z = 0; z < N; z++) {
                    matrix[j][z] -= 1;
                }
            }

            int cnt = 0;
            for (int a = 0; a < matrix.length; a++) {
                for (int b = 0; b < matrix.length; b++) {
                    if (!visited[a][b] && matrix[a][b] > 0) {
                        bfs(a, b);
                        cnt++;
                    }
                }
            }
            result = Math.max(result, cnt);
        }
        if (result == 0) {
            result = 1;
        }

        System.out.println(result);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void bfs(int a, int b) {
        q.add(new int[]{a, b});
        while (!q.isEmpty()) {
            visited[a][b] = true;
            int[] poll = q.poll();
            int cx = poll[0];
            int cy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (inner(nx, ny) && !visited[nx][ny] && matrix[nx][ny] > 0) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }

        }
    }

    private static boolean inner(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx > size || ny > size) {
            return false;
        }
        return true;

    }


}
