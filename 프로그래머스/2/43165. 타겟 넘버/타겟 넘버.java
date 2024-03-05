import java.util.*;

class Solution {
    
    public static class NumInfo{
        int num;
        int idx;
        
        public NumInfo(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
    
    static Queue<NumInfo> q = new LinkedList<>();
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        
        
        bfs(0, numbers, target);   
        
        
        
        return answer;
    }
    
    public static void bfs(int start, int[] numbers, int target) {
        q.add(new NumInfo(0, 0));
        while(!q.isEmpty()) {
            NumInfo poll = q.poll();
            
            if (poll.idx == numbers.length) {
                if(poll.num == target) {
                    answer++;
                }
                continue;
            } else {
                int temp = poll.num - numbers[poll.idx]; // 결과값
                q.add(new NumInfo(temp, poll.idx + 1));
                temp = poll.num + numbers[poll.idx];
                q.add(new NumInfo(temp, poll.idx + 1));
            }

        }
    }
}