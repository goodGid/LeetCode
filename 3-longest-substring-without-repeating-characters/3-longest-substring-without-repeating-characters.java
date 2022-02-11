class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {

          if (map.getOrDefault(s.charAt(r), 0) > 0) {
                map.put(s.charAt(l), Math.max(0, map.getOrDefault(l, 0) - 1));
                l++;
            } else {
                ans = Math.max(ans, (r - l + 1));
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
                r++;
            }
        }

        return ans;
    }
}