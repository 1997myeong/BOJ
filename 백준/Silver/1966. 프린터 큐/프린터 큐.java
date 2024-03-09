import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Queue<int[]> q = new LinkedList<>();

        int caseCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < caseCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            StringTokenizer line = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(line.nextToken());
                q.add(new int[]{j, num});
                arr[j] = num;
            }
            Arrays.sort(arr);
            int idx = arr.length - 1;
            int cnt = 1;
            while (!q.isEmpty()) {
                int[] poll = q.poll();
                if (arr[idx] == poll[1]) {
                    if (poll[0] == M) {
                        sb.append(cnt);
                        sb.append("\n");
                    }
                    cnt++;
                    idx--;
                } else {
                    q.add(poll);
                }
            }
        }


        System.out.println(sb);

    }
}
