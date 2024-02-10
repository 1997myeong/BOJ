import java.util.*;
import java.io.*;


public class Main{


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    HashMap<Integer, String> map = new HashMap<>();
    HashMap<String, Integer> mapName = new HashMap<>();

    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= m; i++) {
      String str = br.readLine();
      map.put(i, str);
      mapName.put(str, i);
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      if (isNumber(s)) {
        sb.append(map.get(Integer.parseInt(s)) + "\n");
      } else {
        sb.append(mapName.get(s) + "\n");
      }
    }
    System.out.println(sb.toString());
  }
  static boolean isNumber(String str) {
    char[] charArray = str.toCharArray();
    if (Character.isAlphabetic(charArray[0])) {
      return false;
    } else {
      return true;
    }
  }
}