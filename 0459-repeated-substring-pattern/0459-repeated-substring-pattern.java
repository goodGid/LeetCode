class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int size = s.length();

        for (int i = 1; i <= size / 2; i++) {
            if (size % i != 0) {continue;}
            if (isCheck(s, i)) {
                return true;
            }
        }

        return false;
    }

    private boolean isCheck(String s, int step) {
        int size = s.length();
        String sub = s.substring(0, step);

        for (int i = 0; i < size; i += step) {
            String val = s.substring(i, i + step);
            if (!val.equals(sub)) {
                return false;
            }
        }
        return true;
    }
}