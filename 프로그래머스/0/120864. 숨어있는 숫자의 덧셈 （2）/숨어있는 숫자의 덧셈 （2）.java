class Solution {
    public int solution(String my_string) {
        String ans = "";
        char[] cArr = my_string.toCharArray();
        int result = 0;
        for (int i = 0; i < cArr.length; i++) {
            if(i < cArr.length - 1) {
                if(!isAlpha(cArr[i])) {
                ans += String.valueOf(cArr[i]);
                    if(isAlpha(cArr[i + 1])) {
                        result += Integer.parseInt(ans);
                        ans = "";
                    }
                } 
            } else {
                if(!isAlpha(cArr[i])) {
                    ans += String.valueOf(cArr[i]);
                    result += Integer.parseInt(ans);
                }
            }
            
        }
        
        return result;
    }
    public static boolean isAlpha(char c) {
        return Character.isAlphabetic(c);
    }
}