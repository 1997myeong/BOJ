import java.util.*;
import java.io.*;


public class Main{
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      String s = st.nextToken();

      for (char c : s.toCharArray()) {
        for (int j = 0; j < r; j++) {
          sb.append(c);
        }
      }
      sb.append("\n");
    }

    System.out.println(sb.toString());



  }
}