import java.util.*;

class Solution {
    public static boolean visited[];
    public static Queue<Integer> q = new LinkedList<>();
    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        int answer = 0;
        for(int i = 0; i < computers.length; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i] && computers[i][j] == 1) {
                    bfs(i, computers);
                    answer++;
                }
            }

        }


        return answer;
    }

    public static void bfs(int num, int[][] computers) {
        q.add(num);
        visited[num] = true;
        while(!q.isEmpty()) {
            int a = q.poll();
            for(int i = 0; i < computers.length; i++) {
                if(!visited[i] && computers[a][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }

        }
    }
}
// 1 1 0
// 1 1 0
// 0 0 1