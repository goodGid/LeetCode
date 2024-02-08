class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            List<String> values = map.get(key);
            values.add(s);
            map.put(key, values);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()) {
            ans.add(map.get(key));
        }
        
        return ans;
    }
}