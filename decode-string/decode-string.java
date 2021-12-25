class Solution {
    private char OPEN = '[';
    private char CLOSE = ']';

    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();

        int head = 0;

        while (s.length() > head) {

            if (Character.isAlphabetic(s.charAt(head))) {
                ans.append(s.charAt(head++));
            } else if (Character.isDigit(s.charAt(head))) {

                int digit = 0;

                while (Character.isDigit(s.charAt(head))) {
                    digit *= 10;
                    digit += s.charAt(head) - 48;
                    head++;
                }

                int startIdx = head + 1;
                int endIdx = findCloseIndex(s);

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < digit; i++) {
                    sb.append(s, startIdx, endIdx);
                }
                sb.append(s.substring(endIdx + 1));
                s = sb.toString();
                head = 0;
            }
        }

        return ans.toString();
    }

    private int findCloseIndex(String s) {
        int openCnt = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == OPEN) {
                openCnt++;
            } else if (chars[i] == CLOSE) {
                openCnt--;
                if (openCnt == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}