class Solution {
    public String reorganizeString(String s) {
        char[] arr = s.toCharArray();
        int size = s.length();
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character key : map.keySet()) {
            Integer i = map.get(key);
            pq.add(new Node(key, i));
        }

        if (pq.peek().cnt > (size + 1) / 2) {
            return "";
        }

        char[] ans = new char[size];
        int idx = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (int i = 0; i < node.cnt; i++) {
                ans[idx] = node.c;
                idx += 2;
                if (idx >= size) {
                    idx = 1;
                }
            }
        }
        return String.valueOf(ans);
    }

    class Node {
        char c;
        int cnt;

        public Node(char _c, int _cnt) {
            c = _c;
            cnt = _cnt;
        }

        public int getValue() {
            return this.cnt;
        }
    }
}