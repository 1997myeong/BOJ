import java.util.*;
class Solution {
    public class Task{
        int progress;
        int speed;

        public Task() {
        }

        public Task(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

    }
    public int[] solution(int[] progresses, int[] speeds) {



        Queue<Task> q = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++) {
            Task task = new Task(progresses[i], speeds[i]);
            q.add(task);
        }

        int day = 1;
        Queue<Integer> countQ = new LinkedList<>();
        boolean con = true; // 하루에 배포되는지 확인
        int count = 0; // 하루에 배포되는 작업 숫자
        while(!q.isEmpty()) {
            Task task = q.peek();

            int cal = task.progress + (task.speed * day);
            if(cal >= 100) { // 100 % 완료 하였다면
                count++;
                con = true;
                q.poll();

            } else { // 완료하지 못한경우
                con = false;
                day++;
            }
            if(!con && count >= 1) {
                
                countQ.add(count);
                count = 0;
            } else if(!con) {
                count = 0;
            }
        }
        if(count != 0) {
            countQ.add(count);
        }
        
        

        int[] answer = new int[countQ.size()];
        int idx = 0;
        while(!countQ.isEmpty()) {
            answer[idx++] = countQ.poll();

        }



        return answer;
    }
}