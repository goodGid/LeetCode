class Solution {
    public boolean validPalindrome(String s) {
        return valid(s.toCharArray(), 0, s.length()-1, true);
    }
    
    private boolean valid(char[] s, int left, int right, boolean isSkipable) {
        boolean ans = true;
        while (left < right) {
            if (s[left] == s[right]) {
                left ++;
                right --;
            } else if (isSkipable == false) {
                return false;
            } else {
                return valid(s,left+1,right,false) || valid(s,left,right-1,false);
            }
        }
        return ans;
    }
}