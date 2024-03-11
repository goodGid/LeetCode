class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                int val = map.get(c);
                for (int i=0; i<val; i++) {
                    sb.append(String.valueOf(c));
                }
                map.remove(c);
            }
        }
        
        for (char key : map.keySet()) {
            int val = map.get(key);
            for (int i=0; i<val; i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}