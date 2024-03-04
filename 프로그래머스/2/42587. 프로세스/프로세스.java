import java.util.*;

class Solution {
    public static class Process{
        int location;
        int priority;

        public Process(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }


    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] arr = new int[10]; // 해당 우선순위 갯수 카운트
        Queue<Process> q = new LinkedList<>();
        int loc = 0;
        for(int a : priorities) {
            arr[a]++;
            q.add(new Process(loc++, a));
        }

        int cnt = 0;
        while(!q.isEmpty()) {
            boolean check = false;
            Process p = q.poll();
            
            int num = p.priority;
            if (num == 9) {

            } else {
                for (int i = num + 1; i <= 9; i++) {
                    if (arr[i] > 0) { // 우선순위 높은 프로세스가 존재한다면
                        q.add(p);
                        check = true;
                        break;
                    }
                }
            }


            if(!check && p.location == location) {
                return priorities.length - q.size();
            } else if (!check) {
                arr[p.priority]--;
            }


        }



        return answer;
    }

}