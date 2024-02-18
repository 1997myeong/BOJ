import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        HashSet<Integer> hs = new HashSet<>();

        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            input[i] = a;
            hs.add(a);
        }
        int[] arr = new int[hs.size()];

        int cnt = 0;
        for (int a : hs) {
            arr[cnt++] = a;
        }

        Arrays.sort(arr);

        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < input.length; i++) {
            sb.append(map.get(input[i]) + " ");
        }

        System.out.println(sb);




    }
}
