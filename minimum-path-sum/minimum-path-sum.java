class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dp = new int[n+1][m+1];
        
        for (int i=0; i<m-1; i++) {
            dp[n][i] = 987654321;
        }
        
        for (int i=0; i<n-1; i++) {
            dp[i][m] = 987654321;
        }
        
        
        for (int i=n-1; i>=0; i--) {
            for (int j=m-1; j>=0; j--) {
                dp[i][j] = Math.min(dp[i][j+1], dp[i+1][j]) + grid[i][j];
            }
        }        
        return dp[0][0];
    }
}