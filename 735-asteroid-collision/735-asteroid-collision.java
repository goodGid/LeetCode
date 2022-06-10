class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i : asteroids) {
            if (st.isEmpty()) {
                st.push(i);
                continue;
            }

            int top = st.peek();

            if (top > 0) {
                if (i > 0) {
                    st.push(i);
                } else {
                    cal(st, i);
                }
            } else {
                st.push(i);
            }
        }

        int size = st.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }

    private void cal(Stack<Integer> st, int i) {
        while (!st.isEmpty() && st.peek() > 0) {
            int top = st.peek();
            if (top > i * -1) {
                return;
            } else if (top == i * -1) {
                st.pop();
                return;
            } else {
                st.pop();
            }
        }
        st.push(i);
    }
}