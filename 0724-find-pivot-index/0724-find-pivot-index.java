class Solution {
    public int pivotIndex(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n+2];
        
        for (int i=0; i<n; i++) {
            dp[i+1] = nums[i] + dp[i];
        }

        int ans = -1;
        for (int i=1; i<=n; i++) { 
            if (dp[i-1] == dp[n] - dp[i]) {
                return i-1;
            }
        }
        
        return -1;
    }
}