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
        int[] aPlusB = new int[arr.length * (arr.length + 1) / 2];

        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                aPlusB[idx++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(aPlusB); // 이분탐색을 위해 정렬한다.



        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (binarySearch(aPlusB, arr[i] - arr[j])) {
                    result = Math.max(result, arr[i]);
                }
            }
        }
        System.out.println(result);
    }

    // 정렬된 배열 arr 과, 정수 a가 주어졌을때 arr 배열에서 a값이 있는가
    static boolean binarySearch(int[] arr, int a) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a > arr[mid]) {
                left = mid + 1;
            } else if (a < arr[mid]) {
                right = mid - 1;
            } else if (a == arr[mid]) {
                return true;
            }
        }
        return false;
    }
}
