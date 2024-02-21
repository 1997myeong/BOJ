import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arrA = br.readLine().split("");
        String[] arrB = br.readLine().split("");

        int[][] lcs = new int[arrB.length + 1][arrA.length + 1];
        int result = 0;
        for (int i = 1; i <= arrB.length; i++) {
            for (int j = 1; j <= arrA.length; j++) {
                if (arrB[i - 1].equals(arrA[j - 1])) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                }
                result = Math.max(result, lcs[i][j]);
            }
        }
        System.out.println(result);
    }
}
