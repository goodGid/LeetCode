class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[59];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i=2; i<=n; i++) {
            int ans = -1;
            for (int j=i-1; j>=0; j--) {
                ans = Math.max(ans,Math.max(j*dp[i-j], j*(i-j)));
            }
            dp[i]=ans;
        }
        return dp[n];
    }
}