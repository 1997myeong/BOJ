import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer one = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(one.nextToken()); // 세로
        int w = Integer.parseInt(one.nextToken()); // 가로


        StringTokenizer two = new StringTokenizer(br.readLine());

        int[] floor = new int[w];
        for (int i = 0; i < w; i++) {
            floor[i] = Integer.parseInt(two.nextToken());
        }




        int ans = 0;
        for (int i = 1; i <= h; i++) { // 블럭 높이를 기준으로 빗물의 양을 구해나간다.
            int front = -1;
            int rear = floor.length - 1;
            int cnt = 0;
            for (int j = 0; j < floor.length; j++) {
                if (front == -1 && floor[j] >= i) { // i 이상의 높이인 가장 앞의 블럭
                    front = j;
                }
                if (floor[j] >= i) { // i 이상의 높이인 가장 뒤의 블럭
                    rear = j;
                    cnt++; // 범위내의 블럭 개수
                }
            }
            if (front == -1) {
                break;
            }
            if (front != rear) {
                // 예를들어 rear = 3, front = 0일 경우 범위 내의 블럭은 총 4개인데
                // rear - front = 3 이기 때문에 +1 을 해주어야한다.
                ans += rear - front - cnt + 1;
            } else {
                ans += 0;
                break; // 조건에 만족하는 rear 와 front 가 같다면 이 이상 높이엔 비가 고일 수 없다
            }
        }

        System.out.println(ans);





    }
}
