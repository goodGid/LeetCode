class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        1 <= strs.length <= 10^4
        0 <= strs[i].length <= 100
        */

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            char tempArray[] = s.toCharArray();
            Arrays.sort(tempArray);
            String key = new String(tempArray);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.computeIfPresent(key, (k, v) -> {
                v.add(s);
                return v;
            });
        }

        List<List<String>> ans = new ArrayList<>();

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            ans.add(map.get(key));
        }
        return ans;
    }
}

/*
for (...) {
    - sort in ascending order
    - push map
}

- make answer list

return list;
*/