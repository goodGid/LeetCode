class Solution {
    int ans = 100009;
    int[] ansIdx = { -1, -1 };
    Map<Character, Integer> map = new HashMap<>();
    char[] cs;

    public String minWindow(String s, String t) {
        cs = s.toCharArray();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;
        int length = s.length();
        while (r < length) {
            char c = cs[r];
            if (map.containsKey(c)) {
                int value = map.get(c);
                map.put(c, value - 1);
            }
            if (isPossible(map)) {
                if (ans > r - l + 1) {
                    ans = Math.min(ans, r - l + 1);
                    ansIdx[0] = l;
                    ansIdx[1] = r;
                }
                l = getNextLeftIdx(cs, map, l, r);
            }
            r++;
        }

        if (ansIdx[0] == -1) {
            return "";
        }
        return s.substring(ansIdx[0], ansIdx[1] + 1);
    }

    private int getNextLeftIdx(char[] cs, Map<Character, Integer> map, int l, int r) {
        while (l <= r) {
            char c = cs[l];

            if (map.containsKey(c)) {
                int value = map.get(c);
                map.put(c, value + 1);
            }
            l++;

            if (isPossible(map)) {
                if (ans > r - l + 1) {
                    ans = Math.min(ans, r - l + 1);
                    ansIdx[0] = l;
                    ansIdx[1] = r;
                }
            } else {
                break;
            }
        }
        return l;
    }

    private boolean isPossible(Map<Character, Integer> map) {
        for (char key : map.keySet()) {
            if (map.get(key) > 0) {
                return false;
            }
        }
        return true;
    }
}