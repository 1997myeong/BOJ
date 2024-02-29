import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer line = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(line.nextToken());
        int L = Integer.parseInt(line.nextToken());

        StringBuilder sb = new StringBuilder();

        StringTokenizer A = new StringTokenizer(br.readLine());

        Deque<Node> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            int cA = Integer.parseInt(A.nextToken());

            while (!deque.isEmpty() && cA < deque.getLast().value) {
                deque.pollLast();
            }

            deque.addLast(new Node(i, cA));


            if (deque.getFirst().index <= i - L) {
                deque.pollFirst();
            }

            sb.append(deque.peekFirst().value + " ");

        }


        System.out.println(sb);
    }

    public static class Node{
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
