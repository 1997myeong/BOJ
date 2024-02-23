import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            long sum = 0;
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            while (pq.size() != 1) {
                long tmp = pq.poll() + pq.poll();
                sum += tmp;
                pq.add(tmp);
            }
            sb.append(sum);
            sb.append("\n");
        }


        System.out.println(sb);

    }
}
