class Solution {
    public boolean halvesAreAlike(String _s) {
        String s = _s.toUpperCase();
        int size = s.length();
        char[] ch = s.toCharArray();
        int cnt = 0;
        for (int i=0; i<size/2; i++) {
            if (isVowels(ch[i])) {
                cnt++;
            }
        }
        
        char[] rightString = new char[size/2];
        for (int i=size/2; i<size; i++) {
            if (isVowels(ch[i])) {
                cnt--;
            }
        }
        return cnt == 0 ? true : false;
    }
    
    private boolean isVowels(char c) {
        if (c == 'A' ||
            c == 'E' ||
            c == 'I' ||
            c == 'O' ||
            c == 'U') {
            return true;
        }
        return false;
    }
}