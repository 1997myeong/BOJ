import java.util.*;

class Solution {
    static char[] nArr;
    static HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        nArr = numbers.toCharArray();
        boolean[] arr = new boolean[numbers.length()];
        dfs("", numbers.length(), 0, arr);
        return set.size();
    }


    public void dfs(String s, int numberLen, int len, boolean[] visit) {
        
        if (len > numberLen) {
            return;
        }

        if(s.equals("")) {
        } else {
            check(s);
        }


        for(int i = 0; i < numberLen; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(s + nArr[i], numberLen, len + 1, visit);
                visit[i] = false;
            }
        }

    }



    public void check(String num) {
        int number = Integer.parseInt(num);
        int cnt = 0;
        if(number <= 1) {
            return;
        }
        for(int i = 1; i <= number; i++) {
            if (number % i == 0) {
                cnt++;
                if(cnt > 2) {
                    return;
                }
            }
        }
        set.add(number);
        System.out.print(number + " ");
    }
}