class Solution {

  private int answer;
  private int len;
  private boolean[][] dp;

  public int countSubstrings(String s) {
    initData(s);
    findPalindrome(s);
    return answer;
  }

  private void findPalindrome(String s) {
    for (int j = 0; j < len; j++) {
      for (int i = j; i >= 0; i--) {
        if (isPalindrome(i, j, s)) {
          dp[i][j] = true;
          answer++;
        }
      }
    }
  }

  private void initData(String s) {
    len = s.length();
    dp = new boolean[len][len];
  }

  private boolean isPalindrome(int i, int j, String s) {
    if (i == j) {
      return true;
    }
    if (s.charAt(i) != s.charAt(j)) {
      return false;
    }
    
      if (j - i - 1 == 0) {
      return true;
    } else {
      return dp[i + 1][j - 1];
    }
  }
}