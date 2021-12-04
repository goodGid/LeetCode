class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        go(digits, "", 0, ans);
        return ans;
    }
    
    private void go(String digits, String s, int idx, List<String> ans) {
        if (idx == digits.length()) {
            ans.add(s);
            return ;
        }

        List<String> mappedString = getMappedString(digits.charAt(idx));
        
        for (int i = 0; i<mappedString.size(); i++) {
            go(digits, s + mappedString.get(i), idx + 1, ans);
        }
    }
    
    
    private List<String> getMappedString(char c) {
        if (c == '2') {
            return Arrays.asList("a","b","c");
        } else if (c == '3') {
            return Arrays.asList("d", "e", "f");
        } else if (c == '4') {
            return Arrays.asList("g", "h", "i");
        } else if (c == '5') {
            return Arrays.asList("j", "k", "l");
        } else if (c == '6') {
            return Arrays.asList("m", "n", "o");
        } else if (c == '7') {
            return Arrays.asList("p", "q", "r", "s");
        } else if (c == '8') {
            return Arrays.asList("t", "u", "v");
        } else {
            return Arrays.asList("w", "x", "y", "z");
        }
    }
    
}