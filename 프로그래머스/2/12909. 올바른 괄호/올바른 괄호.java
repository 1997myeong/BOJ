import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
       
        
        for (String str : s.split("")) {
            if ("(".equals(str)) {
                stack.push(str);
            } else if (stack.isEmpty()) {
                return false;   
            } else {
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) {
            answer = false;
        }
        
        return answer;
    }
}