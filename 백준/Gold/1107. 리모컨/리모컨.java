import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static HashSet<String> hs = new HashSet<>();
    static int plus = 0;
    static int len = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean broken = false;

        if (M == 0) { // M 이 0 일 경우 N의 길이가 정답이다.
            plus = String.valueOf(N).length();

        } else {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                hs.add(String.valueOf(i));
            }
            for (int i = 0; i < M; i++) {
                hs.remove(st.nextToken());
            }
            // hs 에는 정상 버튼만 들어있다.


            boolean p = false;
            boolean m = false;
            int maxNumber = Math.abs(N - 100);
            while (!p && !m) {
                if (plus >= maxNumber) {
                    broken = true;
                    break;
                }

                int a = N + plus;
                int b = N - plus;

                p = cal(a);
                m = cal(b);

                plus++;
            }

            if (m) {
                int a = N - plus + 1;
                len = String.valueOf(a).length();
            } else {
                int a = N + plus - 1;
                len = String.valueOf(a).length();
            }

        }


        int result = Math.min(Math.abs(N - 100), plus + len - 1);
        if (M == 0) {
            result = Math.min(Math.abs(N - 100), plus + len);
        }
        if (broken) {
            result = Math.abs(N - 100);
        }


        System.out.println(result);
    }


    static boolean cal(int n) {

        String s = String.valueOf(n);
        for (String str : s.split("")) {
            if (!hs.contains(str)) {
                return false;
            }
        }
        return true;
    }
}
