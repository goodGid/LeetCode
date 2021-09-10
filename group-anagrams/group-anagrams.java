
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            final String value = strs[i];
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);

            String key = Arrays.toString(charArray);
            if (map.containsKey(key)) {
                map.computeIfPresent(key, (k, v) -> {
                    v.add(value);
                    return v;
                });
            } else {
                map.put(key, new ArrayList<>(Collections.singleton(value)));
            }
        }

        List<List<String>> answer = new ArrayList<>();

        for (Map.Entry<String, List<String>> item : map.entrySet()){
            answer.add(new ArrayList<>(item.getValue()));
        }
        return answer;
    }
}