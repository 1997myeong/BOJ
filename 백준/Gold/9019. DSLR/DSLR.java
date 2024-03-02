import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static boolean[] visited = new boolean[10000];
    static Queue<Integer> q;
    static String[] sArr = new String[10000];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            q = new LinkedList<>();
            visited = new boolean[10000];
            Arrays.fill(sArr, "");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());


            bfs(before, after);

            sb.append(sArr[after]);
            sb.append("\n");
        }

        System.out.println(sb);


    }

    static void bfs(int num, int after) {
        q.add(num);
        while (!q.isEmpty()) {
            int poll = q.poll();
            if (poll == after) {
                return;
            }
            visited[poll] = true;

            int d = orderD(poll);
            int s = orderS(poll);
            int l = orderL(poll);
            int r = orderR(poll);


            if (!visited[d]) {
                q.add(d);
                visited[d] = true;
                sArr[d] = sArr[poll] + "D";
            }
            if (!visited[s]) {
                q.add(s);
                visited[s] = true;
                sArr[s] = sArr[poll] + "S";
            }
            if (!visited[l]) {
                q.add(l);
                visited[l] = true;
                sArr[l] = sArr[poll] + "L";
            }
            if (!visited[r]) {
                q.add(r);
                visited[r] = true;
                sArr[r] = sArr[poll] + "R";
            }

        }
    }

    static int orderD(int num) {
        return (num * 2) % 10000;
    }

    static int orderS(int num) {
        if (num == 0) return 9999;
        return num - 1;
    }

    static int orderL(int num) {
        int[] arr = new int[4];
        arr[3] = num / 1000;
        num = num % 1000;
        arr[0] = num / 100;
        num = num % 100;
        arr[1] = num / 10;
        num = num % 10;
        arr[2] = num / 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return Integer.parseInt(sb.toString());

    }

    static int orderR(int num) {
        int[] arr = new int[4];
        arr[1] = num / 1000;
        num = num % 1000;
        arr[2] = num / 100;
        num = num % 100;
        arr[3] = num / 10;
        num = num % 10;
        arr[0] = num / 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return Integer.parseInt(sb.toString());
    }
}


// D: n을 2배 mod 10000
// S: n에서 1 빼기, 0의 경우 9999
// L: n을 왼쪽으로 회전
// R: n을 오른쪽으로 회전
