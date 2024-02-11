import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] mrr = new int[M];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mrr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr); // 오름차순 정렬하여 탐색할 수 있게 만든다.


        for (int i = 0; i < mrr.length; i++) {

            int left = 0;
            int right = arr.length - 1;
            int mid = (left + right) / 2;

            while (left <= right) {
                mid = (left + right) / 2;
                if (arr[mid] < mrr[i]) {
                    left = mid + 1;
                } else if (arr[mid] > mrr[i]){
                    right = mid - 1;
                } else {
                    // 찾은 경우에 대한 처리 추가
                    System.out.println(1);
                    break;
                }
            }
            if (left > right) { // 찾지 못한 경우에 대한 처리 추가
                System.out.println(0);
            }
        }


    }
}