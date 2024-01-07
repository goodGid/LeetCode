class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int len = s.length();
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = -1;

        while (true) {
            r++;
            if (r == len) {
                break;
            }
            char c = ch[r];

            while (map.getOrDefault(c, 0) > 0) {
                int leftVal = map.get(ch[l]);
                map.put(ch[l], leftVal - 1);
                l++;
            }
            map.put(c, 1);
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}