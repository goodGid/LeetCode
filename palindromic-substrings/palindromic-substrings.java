class Solution {
    public int countSubstrings(String input) {
        List<String> ans = new ArrayList<>();
        for (int i=0; i<input.length(); i++) {
            go(input, "", ans, i);
        }
        
        return ans.size();
    }
    
    private void go(String input, String s, List<String> ans, int idx) {
        if (input.length() == idx) {
            if (isPalindrom(s)) {
                ans.add(s);
            }
            return ;
        }
        
        if (isPalindrom(s)) {
            ans.add(s);
        }
        
        go(input, s + input.charAt(idx), ans, idx+1);
        
    }
    
    private boolean isPalindrom(String s) {
        if (s.equals("")) {
            return false;
        }
        
        int left = 0;
        int right = s.length()-1;
        
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}