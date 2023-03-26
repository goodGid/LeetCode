class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        int length = s.length();
        if (length < 10) {
            return list;
        }

        for (int i = 0, j = 10; j <= length; i++, j++) {
            String substring = s.substring(i, j);
            if (set.contains(substring)) {
                list.add(substring);
            } else {
                set.add(substring);
            }

        }
        return list.stream().distinct().collect(Collectors.toList());
    }
}
