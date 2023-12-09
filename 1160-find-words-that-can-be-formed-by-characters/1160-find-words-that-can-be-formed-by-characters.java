class Solution {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        char[] pivot = new char[26];
        
        for (char c : chars.toCharArray()) {
            pivot[c-'a']++;
        }
        
        for (String s : words) {
            char[] wordsChars = new char[26];
            for (char c : s.toCharArray()) {
                wordsChars[c-'a']++;
            }
            boolean isGood = true;
            for (int i=0; i<26; i++) {
                if (pivot[i] < wordsChars[i]) {
                    isGood = false;
                    break;
                }
            }
            
            if (isGood) {
                ans += s.length();
            }
        }
        
        
        return ans;
    }
}