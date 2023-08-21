/*
ref 
- https://leetcode.com/submissions/detail/1027601276
- https://leetcode.com/submissions/detail/1027193919

- [1] : size를 i로 나눴는데 0으로 안나눠지면 어차피 조건 충족 X
*/
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int size = s.length();

        for (int i = 1; i <= size / 2; i++) {
            if (size % i != 0) {continue;} // [1]
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