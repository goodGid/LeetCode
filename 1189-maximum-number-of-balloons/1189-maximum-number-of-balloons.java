class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] cs = new int[26];
        char pivot = 'a';

        for (char c : text.toCharArray()) {
            cs[c - pivot]++;
        }

        int ans = 0;
        while (cs['b' - pivot] > 0
               && cs['a' - pivot] > 0
               && cs['l' - pivot] > 1
               && cs['o' - pivot] > 1
               && cs['n' - pivot] > 0) {
            ans++;
            cs['b' - pivot]--;
            cs['a' - pivot]--;
            cs['l' - pivot] -= 2;
            cs['o' - pivot] -= 2;
            cs['n' - pivot]--;
        }
        return ans;
    }
}