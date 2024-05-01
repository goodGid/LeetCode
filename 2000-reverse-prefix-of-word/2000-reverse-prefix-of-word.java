class Solution {
    public String reversePrefix(String word, char ch) {
        char[] cs = word.toCharArray();

        Stack<Character> st = new Stack<>();
        boolean isExist = false;

        int idx = 0;
        for (char c : cs) {
            idx++;
            st.add(c);
            if (c == ch) {
                isExist = true;
                break;
            }
        }

        if (isExist == false) {
            return word;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString() + word.substring(idx);
    }
}