import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static String[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        dp = new String[1001];
        
        dp[1] = "SK";
        dp[2] = "CY";
        for (int i = 1; i < dp.length; i++) {
            if(i % 2 == 0) {
                dp[i] = "CY";
            } else {
                dp[i] = "SK";
            }
        }
        System.out.print(dp[N]);


    }
    
    
}