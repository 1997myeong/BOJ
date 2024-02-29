class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, target, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int target, int cal) {
        if (depth == numbers.length) {
            if(target == cal) {
               answer++; 
            }
            
            return;
        } else {
            dfs(numbers, depth + 1, target, cal + numbers[depth]);
            dfs(numbers, depth + 1, target, cal - numbers[depth]);
        }
        
    
            
        
        
    }
}