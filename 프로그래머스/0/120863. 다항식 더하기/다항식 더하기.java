import java.util.*;
class Solution {
    public String solution(String polynomial) {
        String answer = "";
        
        String[] sArr = polynomial.split("\\s*\\+\\s*");
        int[] resultArr = new int[2];
        for(String s : sArr) {
            String num = "";
            boolean alpha = false;
            if("x".equals(s)) {
                s = "1x";
            }
            for (char c : s.toCharArray()) {
                
                if(c >= 'A' && c <= 'z') {
                    alpha = true;
                    break;
                }
                num += String.valueOf(c);
            }
            int number = Integer.parseInt(num);
            if(alpha) {
                resultArr[0] += number;
            } else {
                resultArr[1] += number;
            }
            
        }

        if(resultArr[0] > 1 && resultArr[1] >= 1) {
            answer = resultArr[0] + "x" + " + " + resultArr[1];
        } else if(resultArr[0] > 1 && resultArr[1] == 0) {
            answer = resultArr[0] + "x";
        } else if(resultArr[0] == 1 && resultArr[1] == 0) {
            answer = "x";
        } else if(resultArr[0] == 1 && resultArr[1] >= 1) {
            answer = "x" + " + " + resultArr[1];
        } else if(resultArr[0] == 0 && resultArr[1] == 0) {
            answer = "";
        } else if(resultArr[0] == 0 && resultArr[1] > 0) {
            answer = String.valueOf(resultArr[1]);
        }
        
        return answer;
    }
}