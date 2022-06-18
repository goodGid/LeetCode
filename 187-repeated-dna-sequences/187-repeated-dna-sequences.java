// ref : https://leetcode.com/submissions/detail/725160469

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), ans = new HashSet<>();
        String sub = null;
        for (int i = 0; i <= s.length() - 10; i++) {
            sub = s.substring(i, i + 10);
            if (!seen.add(sub)) {ans.add(sub);}
        }
        return new ArrayList<>(ans);
    }
}