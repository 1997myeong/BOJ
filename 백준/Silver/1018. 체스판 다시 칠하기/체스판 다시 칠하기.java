import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static char[][] arr;

    static char[][] cs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            char[] charArray = s.toCharArray();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = charArray[j - 1];
            }
        }
        //8x8 체스판 W: 하얀색 시작, B: 블랙 시작
        cs = new char[9][9];

        for (int i = 1; i < cs.length; i++) {
            for (int j = 1; j < cs.length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        cs[i][j] = 'W';
                    } else {
                        cs[i][j] = 'B';
                    }
                } else {
                    if (j % 2 == 0) {
                        cs[i][j] = 'B';
                    } else {
                        cs[i][j] = 'W';
                    }
                }
            }
        }


        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n - 7; i++) {
            for (int j = 1; j <= m - 7; j++) {
                min = Math.min(match(i, j), min);
            }
        }


        System.out.println(min);

    }

    // arr 배열의 시작점 a, b 가 주어졌을때, cs 배열과 arr 배열을 비교해서 적게 색칠하는 숫자 리턴
    static int match(int a, int b) {
        int cnt = 0;
        int iIdx = 1;
        for (int i = a; i <= a + 7; i++) {

            int jIdx = 1;
            for (int j = b; j <= b + 7; j++) {
                if (arr[i][j] == cs[iIdx][jIdx]) {
                    cnt++;

                }
                jIdx++;
            }
            iIdx++;
        }


        return Math.min(64 - cnt, cnt); // W시작 바둑판과, B시작 바둑판이 있기때문
    }
}