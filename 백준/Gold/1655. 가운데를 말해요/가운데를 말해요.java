import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (i == 0) {
                maxHeap.add(num);
            } else if (i == 1){
                if (num >= maxHeap.peek()) {
                    minHeap.add(num);
                } else {
                    maxHeap.add(num);
                }
            } else {
                if (num > minHeap.peek()) { // i > 1, 입력받은 숫자가 최소힙의 peek() 값보다 클때
                    minHeap.add(num);
                } else {
                    maxHeap.add(num);
                }
            }

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            } else if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }

            sb.append(maxHeap.peek());
            sb.append("\n");


        }

        System.out.println(sb);

    }

}