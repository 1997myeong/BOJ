class Solution {
    public int[] solution(int brown, int yellow) {
        
        int full = brown + yellow;
        for(int i = 3; i < full / 2; i++) {
            if(full % i == 0) {
                int num = full / i;
                if((i - 2) * (num - 2) == yellow) {
                    return(new int[]{num, i});
                }
            }
        }
        
        return null;
    }
}