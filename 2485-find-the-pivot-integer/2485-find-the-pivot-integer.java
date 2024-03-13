class Solution {
    public int pivotInteger(int n) {
        int[][] dp = new int[2][n+2];
        
        for (int i=1; i<=n; i++) {
            dp[0][i] = i + dp[0][i-1];
        }
        
        for (int i=n; i>0; i--) {
            dp[1][i] = i + dp[1][i+1];
            if (dp[0][i] == dp[1][i]) {
                return i;
            }
        }
        return -1;
    }
}