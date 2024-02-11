import java.util.*;
import java.io.*;


public class Main{


  static int[] arr;
  static int m;
  static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());

    n = Integer.parseInt(st.nextToken());
    br.close();


    arr = new int[n + 1];

    arr[1] = 1;
    arr[2] = 2;
    for (int i = 1; i <= n; i++) {
      if (arr[i] != 1) { // 다음 소수를 골라준다
        int cnt = 2;
        while (i * cnt <= n) { // 해당 소수의 배수를 모두 1로 업데이트
          arr[i * cnt++] = 1;
        }
      }
    }

    for (int i = m; i <= n; i++) {
      if (arr[i] != 1) {
        System.out.println(i);
      }
    }
  }
}