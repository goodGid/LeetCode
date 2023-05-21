class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] splitList = s.split(" ");
        if (pattern.length() != splitList.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char key = pattern.charAt(i);

            if (map.containsValue(splitList[i]) && map.containsKey(pattern.charAt(i)) == false) {
                return false;
            }

            if (!map.containsKey(key)) {
                map.put(key, splitList[i]);
            } else {
                if (!map.get(key).equals(splitList[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}