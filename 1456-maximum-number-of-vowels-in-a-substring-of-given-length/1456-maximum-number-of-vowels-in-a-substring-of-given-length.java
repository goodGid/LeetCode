class Solution {
    Set<Character> set = new HashSet<>();
    char[] c;

    public int maxVowels(String s, int k) {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int l = 0;
        int r = s.length();
        int ans = 0;

        c = s.toCharArray();

        for (int i = 0; i < k; i++) {
            if (set.contains(c[i])) {
                ans++;
            }
            r = i;
        }

        int cnt = ans;

        while (r < s.length()) {
            if (r + 1 == s.length()) {
                break;
            }

            if (isContain(c[++r])) {
                cnt++;
            }

            if (isContain(c[l])) {
                cnt--;
            }
            l++;
            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    private boolean isContain(char target) {
        return set.contains(target);
    }
}