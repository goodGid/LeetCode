class Solution {
    public int[] countBits(int n) {
        
        int[] ansArray = new int[n+1];
        
        for (int i=0; i<=n; i++){
            ansArray[i] = getBitsCountBy(i);
        }
        return ansArray;
    }
    
    public int getBitsCountBy(int n){
        
        int cnt = 0;
        while (n != 0){
            cnt = n % 2 == 0 ? cnt : cnt + 1;
            n /= 2;
        }
        return cnt;
    }
}