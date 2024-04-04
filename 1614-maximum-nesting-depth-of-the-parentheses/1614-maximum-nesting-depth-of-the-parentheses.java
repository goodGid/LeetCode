class Solution {
    public int maxDepth(String s) {
        char[] cs = s.toCharArray();
        
        int ans = 0;
        int cnt = 0;
        for(Character c: cs) {
            if (c == '(') {
                cnt ++;
                ans = Math.max(ans, cnt);
            } else if (c == ')') {
                cnt --;
            } else {
                
            }
        }
        
        return ans;
    }
}