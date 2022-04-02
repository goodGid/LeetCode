class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int ans = 10001;
        int size = t.size();
        int[][] dp = new int[size][size];

        for (int i = 0; i < t.size(); i++) {
            for (int j = 0; j < t.get(i).size(); j++) {
                dp[i][j] = 10001;
            }
        }

        dp[0][0] = t.get(0).get(0);

        for (int i = 1; i < size; i++) {
            int size2 = t.get(i).size();
            for (int j = 0; j < size2; j++) {
                if (isRange(i - 1, j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
                if (isRange(i - 1, j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                }
                dp[i][j] += t.get(i).get(j);
            }
        }

        for (int i = 0; i < size; i++) {
            ans = Math.min(ans, dp[size - 1][i]);
        }

        return ans;
    }

    private boolean isRange(int i, int j) {
        if (0 <= j && j <= i) {
            return true;
        }
        return false;
    }
}