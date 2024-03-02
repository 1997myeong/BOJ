import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int r, c;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int num = (int) Math.pow(2, N);

        call(num, 0, 0);


    }
    private static void call(int size, int a, int b) {

        if (a == r && b == c) {
            System.out.println(cnt);
            return;
        }

        // r행 c열 이 범위 내에 있는 경우
        if (r < a + size && r >= a && c < b + size && c >= b) {
            int newSize = size / 2;

            call(newSize, a, b);
            call(newSize, a, b + newSize);
            call(newSize, a + newSize, b);
            call(newSize, a + newSize, b + newSize);

        } else {
            //  왼쪽위 오른쪽위 왼쪽아래 오른쪽아래 순으로 탐색하기 때문에 범위 밖인경우 크기만큼 더해준다.
            cnt += size * size;
        }

    }
}
