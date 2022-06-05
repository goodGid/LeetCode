class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int t1l = text1.length();
        int t2l = text2.length();
        
        int[][] dp = new int[t1l+1][t2l+1];
        
        for (int i = 1; i<=t1l; i++) {
            for (int j = 1; j<=t2l; j++) {
                if (text1.charAt(i-1)== text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[t1l][t2l];
        
    }
}