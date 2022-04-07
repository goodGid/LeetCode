class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
    
        // dp[0] = 1
        // dp[1 ~ amount] = MAX_VALUE
        int MAX_VALUE = (int)Math.pow(2,31)-1;
        for (int i = 1; i<=amount; i++) {
            dp[i] = MAX_VALUE;
        }
        
        for (int i=0; i<coins.length; i++) {
            for (int j=coins[i]; j<=amount; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }
        
        return dp[amount] == MAX_VALUE ? -1: dp[amount];
        
    
    }
}