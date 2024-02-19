import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long left = 1;
        long right = arr[arr.length - 1] + 1;

        while (left < right) {
            long num = (left + right) / 2;

            long ans = 0;
            for (int i = 0; i < arr.length; i++) {
                ans += arr[i] / num;
            }

            if (ans < N) {
                right = num;

            } else {
                left = num + 1;
            }

        }

        System.out.println(left - 1);


    }
}