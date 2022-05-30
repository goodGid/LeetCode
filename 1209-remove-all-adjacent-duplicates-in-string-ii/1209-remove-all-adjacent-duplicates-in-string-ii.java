class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Node> st = new Stack<>();

        char[] cArray = s.toCharArray();

        String ans = "";
        for (char c : cArray) {
            if (st.isEmpty()) {
                st.add(new Node(c, 1));
                continue;
            }

            Node node = st.pop();

            if (node.val == c) {
                if (node.dupCnt + 1 == k) {
                    continue;
                } else {
                    node.dupCnt++;
                    st.add(node);
                }
            } else {
                st.add(node);
                st.add(new Node(c, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            Node node = st.pop();
            for (int i = 0; i < node.dupCnt; i++) {
                sb.append(node.val);
            }
        }

        return sb.reverse().toString();
    }

    public class Node {
        public char val;
        public int dupCnt;

        public Node(char val, int dupCnt) {
            this.val = val;
            this.dupCnt = dupCnt;
        }
    }
}