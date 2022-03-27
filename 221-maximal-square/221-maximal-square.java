class Solution {
    public int maximalSquare(char[][] matrix) {
        char ZERO = '0';
        char ONE = '1';

        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int maxSize = Math.min(n, m);
        int[][][] dp = new int[n][m][maxSize + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == ZERO) {
                    dp[i][j][1] = ZERO;
                } else {
                    ans = Math.max(ans, 1);
                    dp[i][j][1] = ONE;
                }
            }
        }

        for (int s = 2; s <= maxSize; s++) {
            for (int i = s - 1; i < n; i++) {
                for (int j = s - 1; j < m; j++) {

                    if (matrix[i][j] == ZERO) {
                        dp[i][j][s] = ZERO;
                        continue;
                    }

                    if (dp[i - 1][j][s - 1] == ONE
                        && dp[i][j - 1][s - 1] == ONE
                        && dp[i - 1][j - 1][s - 1] == ONE) {
                        ans = Math.max(ans, s * s);
                        dp[i][j][s] = ONE;
                    } else {
                        dp[i][j][s] = ZERO;
                    }
                }
            }
        }
        return ans;
    }
}