class Solution {
    static int cnt = 0;
    static boolean[] visit;

    public void dfs(int[][] arr, int len, boolean[] visited, int left, int enter, int max) {


        if (arr[enter][0] <= left) { // 던전 클리어 후 남은 피로도, 탐색 횟수 증가
            left = left - arr[enter][1];
            max++;
        }

        if (len == arr.length) {
            cnt = Math.max(cnt, max);
            return;
        }


        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(arr, len + 1, visited, left, i, max);
                visited[i] = false;
            }

        }

    }

    public int solution(int k, int[][] dungeons) {

        visit = new boolean[dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {

            visit[i] = true;
            dfs(dungeons, 1, visit, k, i, 0);
            visit[i] = false;

        }

        return cnt;
    }

}