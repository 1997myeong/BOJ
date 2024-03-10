import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] copy = arr.clone();
        Arrays.sort(arr);


        int cnt = 0;
        int result = 0;
        int[] resultArr = new int[5];
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == copy[j]) {
                    resultArr[cnt] = j + 1;
                    cnt++;
                    result += arr[i];
                    break;
                }
            }
            if (cnt == 5) {
                break;
            }
        }
        Arrays.sort(resultArr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultArr.length; i++) {
            sb.append(resultArr[i] + " ");
        }
        System.out.println(result);
        System.out.println(sb);


    }
}
