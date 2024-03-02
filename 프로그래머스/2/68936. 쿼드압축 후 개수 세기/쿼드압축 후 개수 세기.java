class Solution {
    
    private class Count{
        int zero;
        int one;
        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
        
        public Count add(Count o1) {
            return new Count(o1.zero + zero, o1.one + one);
        }
    }
    
    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size / 2;
        for (int i = offsetX; i < offsetX + size; i++) {
            for (int j = offsetY; j < offsetY + size; j++) {
                if(arr[j][i] != arr[offsetY][offsetX]) {
                    return count(offsetX, offsetY, h, arr)
                        .add(count(offsetX, offsetY + h, h, arr))
                        .add(count(offsetX + h, offsetY, h, arr))
                        .add(count(offsetX + h, offsetY + h, h, arr));
                    
                }
            }
        }
        
        if(arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }
        return new Count(1, 0);
        
    }
    
    
    public int[] solution(int[][] arr) {
        
        Count count = count(0, 0, arr.length, arr);
        return new int[]{count.zero, count.one};
    }
}