import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer lineA = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(lineA.nextToken());
        int S = Integer.parseInt(lineA.nextToken());

        StringTokenizer lineB = new StringTokenizer(br.readLine());

        int[] input = new int[N];
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(lineB.nextToken());
        }
        int result = 0;

        for (int i = 0; i < input.length; i++) {
            int sum = 0;
            int start = i;
            int end = start;

            for (int j = start; j < input.length; j++) {
                sum += input[j];
                if (sum >= S) {
                    end = j;
                    answer[i] = end - start + 1;
                    result = answer[i];
                    break;
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] != 0) {
                result = Math.min(answer[i], result);
            }
        }
        System.out.println(result);
    }
}
