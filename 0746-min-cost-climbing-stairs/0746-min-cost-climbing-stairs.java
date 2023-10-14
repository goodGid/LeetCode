class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int lastIdx = cost.length-1;
        int[] dp = new int[cost.length];
        
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i=2; i<cost.length; i++) {
            dp[i] = Math.min(dp[i-2], dp[i-1]) + cost[i];
        }
        
        return Math.min(dp[lastIdx-1], dp[lastIdx]);
    }
}