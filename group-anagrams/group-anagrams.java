class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] tempArray = s.toCharArray();
            Arrays.sort(tempArray);

            String key = String.valueOf(tempArray);
            if (map.containsKey(key)) {
                ArrayList<String> values = map.get(key);
                values.add(s);
                map.put(key, values);
            } else {
                map.put(key, new ArrayList<String>() {
                    {
                        add(s);
                    }
                });
            }
        }

        for (Map.Entry<String, ArrayList<String>> item : map.entrySet()) {
            ans.add(item.getValue());
        }
        return ans;
    }
}