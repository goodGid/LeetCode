class Solution {
    public int trap(int[] h) {
        int ans = 0;
        Stack<Node> st = new Stack<>();

        Node maxNode = new Node(-1, -1);

        for (int i = 0; i < h.length; i++) {
            if (h[i] != 0) {
                maxNode = new Node(i, h[i]);
                st.add(new Node(i, h[i]));
                break;
            }
        }

        for (int i = maxNode.idx + 1; i < h.length; i++) {
            if (h[i] == 0) {
                continue;
            }

            if (h[i] >= maxNode.val) {
                int cnt = 0;
                while (st.peek().idx != maxNode.idx && !st.isEmpty()) {
                    cnt += st.pop().val;
                }
                st.pop();
                ans = ans + (i - maxNode.idx - 1) * maxNode.val - cnt;
                maxNode = new Node(i, h[i]);
            }
            st.add(new Node(i, h[i]));
        }

        while (st.size() > 1) {
            Node curNode = st.pop();

            int cnt = 0;
            if (curNode.idx - st.peek().idx == 1 && curNode.val <= st.peek().val) {
                continue;
            }

            while (curNode.val > st.peek().val) {
                cnt += st.pop().val;
            }
            ans = ans + (curNode.idx - st.peek().idx - 1) * curNode.val - cnt;
        }
        return ans;
    }

    class Node {
        public int idx;
        public int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}