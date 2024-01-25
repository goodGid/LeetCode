class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                st.add(cal(st.pop(), st.pop(), s));
            } else {
                st.add(Integer.valueOf(s));
            }
        }
        return st.pop();
    }

    private int cal(int val1, int val2, String s) {
        if (s.equals("+")) {
            return val2 + val1;
        } else if (s.equals("-")) {
            return val2 - val1;
        } else if (s.equals("*")) {
            return val2 * val1;
        } else {
            return val2 / val1;
        }
    }
}