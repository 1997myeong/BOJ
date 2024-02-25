import java.io.*;
import java.util.*;

public class Main {

    public static class Room{
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer line = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(line.nextToken());


        ArrayList<Room> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer nLine = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(nLine.nextToken());
            int end = Integer.parseInt(nLine.nextToken());
            Room room = new Room(start, end);
            arr.add(room);
        }
        Collections.sort(arr, new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                if (o1.start > o2.start) {
                    return 1;
                } else if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start == o2.start) {
                    return o1.end - o2.end;
                } else {
                    return 0;
                }
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.size(); i++) {
            int end = arr.get(i).end;
            int start = arr.get(i).start;
            if (pq.isEmpty()) {
                pq.add(end);
            } else {
                int peek = pq.peek();

                if (start >= peek) {
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

