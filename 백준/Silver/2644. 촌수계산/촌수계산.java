import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] edge; // 그래프의 간선정보

    static int[] visited;

    static Queue<Integer> q = new LinkedList<>();

    static int cnt;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 전체사람수

        edge = new int[N + 1][N + 1];
        visited = new int[N + 1];

        StringTokenizer persons = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(persons.nextToken());
        int b = Integer.parseInt(persons.nextToken());

        int edgeCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < edgeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edge[x][y] = edge[y][x] = 1;
        }
        dfs(a, b);
        if (cnt == 0) {
            System.out.println("-1");
        } else {
            System.out.println(cnt);
        }



    }

    // bfs 를 이용한 풀이
    static void bfs(int a, int b) {
        q.add(a);
        while (!q.isEmpty()) {
            int num = q.poll();
            if (num == b) {
                cnt = visited[num];
            }
            for (int i = 1; i <= edge.length; i++) {
                if (edge[num][i] == 1 && visited[i] == 0) {
                    visited[i] = visited[num] + 1;
                    q.add(i);
                }
            }
            
        }
    }

    // dfs 를 이용한 풀이
    static void dfs(int a, int b) {

        if (a == b) {
            cnt = visited[a];
        }
        for (int i = 1; i < edge.length; i++) {
            if (edge[a][i] == 1 && visited[i] == 0) {
                visited[i] = visited[a] + 1;
                dfs(i, b);
            }
        }

    }
}
