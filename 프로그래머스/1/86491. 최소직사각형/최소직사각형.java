import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int longLength = 0;
        int shortLength = 0;
        
        int resultLong = 0;
        int resultShort = 0;
        for(int i = 0; i < sizes.length; i++) {
            longLength = Math.max(sizes[i][0], sizes[i][1]);
            shortLength = Math.min(sizes[i][0], sizes[i][1]);
            
            resultLong = Math.max(resultLong, longLength);
            resultShort = Math.max(resultShort, shortLength);
        }
        
        answer = resultLong * resultShort;
        
        
        return answer;
    }
}