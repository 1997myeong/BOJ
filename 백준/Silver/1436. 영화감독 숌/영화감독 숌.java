import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int cnt = 0;
        int number = 665;

        while (cnt != N) {
            number++;

            String num = Integer.toString(number);

            if (num.contains("666")) { // 666이 포함되어있으면
                cnt++;
            }


        }
        System.out.println(number);


    }
}