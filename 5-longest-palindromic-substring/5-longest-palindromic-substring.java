class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int size = s.length();

        int[][] dp = new int[size][size];

        for (int i = 0; i < size; i++) {
            dp[i][i] = 1;
            ans = s.charAt(i) + "";
        }

        for (int i = 1; i < size; i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = 1;
                ans = s.substring(i - 1, i + 1);
            } else {
                dp[i - 1][i] = 0;
            }
        }

        for (int i = 2; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (s.charAt(j - i) == s.charAt(j) && dp[j - i + 1][j - 1] == 1) {
                    dp[j - i][j] = 1;
                    ans = s.substring(j - i, j + 1);
                } else {
                    dp[j - i][j] = 0;
                }
            }
        }
        return ans;
    }
}