// ref : https://leetcode.com/problems/valid-palindrome-ii/discuss/1904942/JavaC%2B%2B-Awesome-Visuall-EXPLANATION

class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
        }
        return true;
    }
    public boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
}