class Solution {
    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (isPal(s)) {
                return s;
            }
        }
        return "";
    }
    
    private boolean isPal(String s) {
        int l = 0;
        int r = s.length() - 1;
        
        char[] cs = s.toCharArray();
        
        while (l <= r) {
            if (cs[l] == cs[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        
        return true;
    }
}