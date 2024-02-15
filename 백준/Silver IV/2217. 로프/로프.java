import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int[] ans = new int[N];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr[i] * (N - i);
        }
        Arrays.sort(ans);
        System.out.println(ans[N - 1]);




    }
}