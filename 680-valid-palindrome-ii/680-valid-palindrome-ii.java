class Solution {    
    public boolean validPalindrome(String s) {
        return check(s, 0, s.length()-1, false);
    }
    
    private boolean check(String s, int l, int r, boolean removed) {
        if (l > r) {
            return true;
        }
        
        while (l<=r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                if (removed) {
                    return false;
                }
                break;
            }
        }
        
        
        return check(s, l+1, r, true) || check(s, l, r - 1, true);
        
    }
    
    
    
}