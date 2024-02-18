class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 10000+1);
        dp[0] = 0;
        
        for (int coin : coins) {
            for (int i=coin; i<=amount; i++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        
        if (dp[amount] == 10000+1) {
            return -1;
        }
        return dp[amount];
    }
}