class Solution {
    public int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        int size = ss.length;
        return ss[size - 1].length();
    }
}