import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String[] split = s.split("\\-");

        int result = 0;

        for (int i = 0; i < split.length; i++) {
            int num = 0;
            if(split[i].contains("+")) {
                StringTokenizer st = new StringTokenizer(split[i], "\\+");
                while (st.hasMoreTokens()) {
                    num += Integer.parseInt(st.nextToken());
                }
            } else {
                num += Integer.parseInt(split[i]);
            }

            if (i == 0) {
                result += num;
            } else {
                result -= num;
            }
        }

        System.out.println(result);

    }
}
