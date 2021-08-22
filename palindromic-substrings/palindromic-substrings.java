class Solution {

    public int countSubstrings(String s) {
        int ans = 0;
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (isPalindrom(chars, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isPalindrom(char[] chars, int st, int end) {
        while (st <= end) {
            if (chars[st] != chars[end]) {
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
}