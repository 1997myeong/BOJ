import java.util.*;

class Solution {

    static boolean visited[][];
    static Queue<int[]> q = new LinkedList<>();
    static int[][] result;
    static int x; // 행 수
    static int y; // 열 수

    public int solution(int[][] maps) {
        int answer = 0;

        x = maps.length;
        y = maps[0].length;
        visited = new boolean[x + 1][y + 1];
        result = new int[x + 1][y + 1];
        result[0][0] = 1;

        visited[0][0] = true;
        bfs(0, 0, maps);




       if(result[x - 1][y - 1] == 0){
           answer = -1;
       }  else {
           answer = result[x - 1][y - 1];
       }

        return answer;
    }
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void bfs(int a, int b, int[][] maps) {
        q.add(new int[]{a, b});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cA = cur[0];
            int cB = cur[1];
            for(int i = 0; i < 4; i++) {
                int nA = cA + dx[i];
                int nB = cB + dy[i];
                if(inner(nA, nB) && maps[nA][nB] == 1 && !visited[nA][nB]) {
                    q.add(new int[]{nA, nB});
                    visited[nA][nB] = true;
                    result[nA][nB] = result[cA][cB] + 1;
                }
            }
        }
    }

    static boolean inner(int a, int b) {
        if(a >= x || b >= y || a < 0 || b < 0) {
            return false;
        } else {
            return true;
        }
    }


}

//[[1,0,1,1,1],
//[1,0,1,0,1],
//[1,0,1,1,1],
//[1,1,1,0,1],
//[0,0,0,0,1]]