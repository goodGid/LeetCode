
class Solution {
    public int[] countBits(int n) {
        
        if (n == 0) {
            return new int[] { 0 };
        }
        
        int[] ans = new int[n + 1];
        int[] dp = new int[n + 1];

        ans[0] = dp[0] = 0;
        ans[1] = dp[1] = 1;

        int pivot = 0;

        for (int i = 2; i <= n; i++) {
            if (twoN(i)) {
                ans[i] = dp[i] = 1;
                pivot++;
                continue;
            }

            int pow = (int) Math.pow(2, pivot);
            dp[i] = 1 + dp[i - pow];
            ans[i] = dp[i];
        }

        return ans;
    }

    private boolean twoN(int num) {
        return (num & (num - 1)) == 0;
    }
}