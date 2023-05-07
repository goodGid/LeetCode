class Solution {
    public String removeKdigits(String num, int k) {
        int size = num.length();
        if (size == k) {
            return "0";
        }

        Stack<Character> st = new Stack<>();
        char[] c = num.toCharArray();

        for (int i = 0; i < size; i++) {
            char cur = c[i];

            while (!st.isEmpty() && st.peek() > cur && k != 0) {
                k--;
                st.pop();
            }

            st.push(cur);
        }

        while (k != 0) {
            k--;
            st.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        String ans = sb.reverse().toString();

         while (ans.startsWith("0") && ans.length() != 1) {
             ans = ans.substring(1);
        }
        return ans;

    }
}