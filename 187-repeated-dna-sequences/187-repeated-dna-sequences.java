// ref : https://leetcode.com/problems/repeated-dna-sequences/discuss/53980/Accepted-Java-easy-to-understand-solution

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        if (s == null || s.length() < 10) {return list;}
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        for (int i = 0; i + 10 <= s.length(); i++) {
            int hash = stringToHash(s.substring(i, i + 10));
            // int hash = stringToHash2(s.substring(i, i + 10));
            if (map.containsKey(hash)) {
                if (!map.get(hash)) {
                    list.add(s.substring(i, i + 10));
                    map.put(hash, true);
                }
            } else {
                map.put(hash, false);
            }
        }
        return list;
    }

    private int stringToHash(String s) {
        String numberBuilder = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {numberBuilder += "0";}
            if (s.charAt(i) == 'C') {numberBuilder += "1";}
            if (s.charAt(i) == 'G') {numberBuilder += "2";}
            if (s.charAt(i) == 'T') {numberBuilder += "3";}
        }
        return Integer.parseInt(numberBuilder, 4);
    }

    private int stringToHash2(String s) {
        int numberBuilder = 0;
        for (int i = 0; i < s.length(); i++) {
            numberBuilder *= 4;
            if (s.charAt(i) == 'A') {
                numberBuilder += 0;
            } else if (s.charAt(i) == 'C') {
                numberBuilder += 1;
            } else if (s.charAt(i) == 'G') {
                numberBuilder += 2;
            } else if (s.charAt(i) == 'T') {
                numberBuilder += 3;
            }
        }
        return numberBuilder;
    }
}