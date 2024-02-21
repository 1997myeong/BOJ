import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr = new int[100001];
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max = Math.max(N, K);


        System.out.println(bfs(N, K));

    }


    static int bfs(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        visited[a] = 1;
        while (!q.isEmpty()) {
            int poll = q.poll();
            if (poll == b) {
                return arr[b];
            }


            if ((poll + 1) < arr.length && visited[poll + 1] != 1) {
                arr[poll + 1] = arr[poll] + 1;
                visited[poll + 1] = 1;
                q.add(poll + 1);
            }
            if ((poll - 1) >= 0 && visited[poll - 1] != 1) {
                arr[poll - 1] = arr[poll] + 1;
                visited[poll - 1] = 1;
                q.add(poll - 1);
            }
            if ((poll * 2) < arr.length && visited[poll * 2] != 1) {
                arr[poll * 2] = arr[poll] + 1;
                visited[poll * 2] = 1;
                q.add(poll * 2);
            }

        }
        return -1;
    }


}