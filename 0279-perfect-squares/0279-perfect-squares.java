class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        
        for (int i=1; i<=n; i++) {
            dp[i] = i;
        }
        
        for (int i=1; i*i<=n; i++) {
            dp[i*i] = 1;
            for (int st=i*i; st<=n; st++) {
                dp[st] = Math.min(dp[st], 1 + dp[st-(i*i)]);
            }
        }
        return dp[n];
    }
}