import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 좌 우 더한 값을 mid 라고 하였을때
        // mid > 0 이면, right 를 -1
        // mid < 0 이면, left 를 + 1
        int left = 0;
        int right = arr.length - 1;
        int minVal = Integer.MAX_VALUE;
        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MIN_VALUE;
        while (left < right) {
            int mid = arr[left] + arr[right];
            int absMid = Math.abs(mid);
            if (minVal > absMid) {
                minVal = absMid;
                minLeft = arr[left];
                minRight = arr[right];
            }

            if (mid < 0) {
                left++;
            } else if (mid > 0) {
                right--;
            } else if (mid == 0) {
                break;
            }

        }
        StringBuilder sb = new StringBuilder();
        sb.append(minLeft);
        sb.append(" ");
        sb.append(minRight);
        

        System.out.println(sb);
    }
}
