class Solution {
    int MOD = 1000000007;
    int A = 0, E = 1, I = 2, O = 3, U = 4;
    int[][] dp = new int[20001][5];

    public int countVowelPermutation(int n) {
        for (int i = 0; i < 5; i++) {dp[1][i] = 1;}

        for (int i = 2; i <= n; i++) {
            dp[i][A] = mod(mod(dp[i - 1][E] + dp[i - 1][U]) + dp[i - 1][I]);
            dp[i][E] = mod(dp[i - 1][A] + dp[i - 1][I]);
            dp[i][I] = mod(dp[i - 1][E] + dp[i - 1][O]);
            dp[i][O] = dp[i - 1][I];
            dp[i][U] = mod(dp[i - 1][O] + dp[i - 1][I]);
        }
        return mod(mod(mod(dp[n][A] + dp[n][E]) + mod(dp[n][I] + dp[n][O])) + dp[n][U]);
    }

    int mod(int val) {
        return val % MOD;
    }
}