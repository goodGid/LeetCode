// ref : https://leetcode.com/problems/longest-valid-parentheses/discuss/5253210/Unlocking-the-Secret-to-Longest-Valid-Parentheses%3A-A-Dynamic-Programming-Guide-oror-1ms-oror-Beats-99.5
class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length();
        int[] dp=new int[n];
        int max=0;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i]=((i>=2)?dp[i-2]:0)+2;
                }
                else if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1)=='('){
                    dp[i]=dp[i-1]+2+(i-dp[i-1]>1?dp[i-dp[i-1]-2]:0);
                }
                max=Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
