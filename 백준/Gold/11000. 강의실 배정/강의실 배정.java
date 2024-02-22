import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Study {
        int start;
        int end;

        public Study() {
        }
        public Study(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Study> studyList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            studyList.add(new Study(start, end));
        }

        Collections.sort(studyList, new Comparator<Study>() {
            @Override
            public int compare(Study o1, Study o2) {
                if (o1.start > o2.start) {
                    return 1;
                } else if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return 0;
            }
        });


        for (int i = 0; i < studyList.size(); i++) {
            int start = studyList.get(i).start;
            int end = studyList.get(i).end;
            if (pq.isEmpty()) {
                pq.add(end);
            } else {
                if (start >= pq.peek()) {
                    pq.poll();
                    pq.add(end);
                } else {
                    pq.add(end);
                }
            }
        }


        System.out.println(pq.size());

    }
}
