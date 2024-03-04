class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int l = 0;
        int r = tokens.length - 1;
        int score = 0;
        int ans = 0;
        
        while (l < r) {
        // System.out.println("ans : " + ans);
        // System.out.println("score : " + score);
        // System.out.println("power : " + power);
        // System.out.println("tokens : " + tokens[l]);
            if (score > 0) {
                if (power >= tokens[l]) {
                    power -= tokens[l];
                    l++;
                    score++;
                    ans = Math.max(ans, score);
                } else {
                    power += tokens[r];
                    r--;
                    score--;
                    ans = Math.max(ans, score);
                }
            } else {
                if (power >= tokens[l]) {
                    power -= tokens[l];
                    l++;
                    score++;
                    ans = Math.max(ans, score);
                } else {
                    break;
                }
            }
        }
        
        // System.out.println("ans : " + ans);
        // System.out.println("score : " + score);
        // System.out.println("power : " + power);
        // System.out.println("tokens : " + tokens[l]);
        if (l == r) {
            if (power >= tokens[l]) {
                ans = Math.max(ans, score+1);
            }
        }
        return ans;
    }
}