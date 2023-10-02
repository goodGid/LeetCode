class Solution {
    public String reorganizeString(String s) {
        char[] arr = s.toCharArray();
        int size = s.length();
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        if (size == 3) {
            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                return "";
            }
            for (int i = 0; i < 3; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            for (Character key : map.keySet()) {
                Integer i = map.get(key);
                pq.add(new Node(key, i));
            }
        } else {
            int maxCnt = 0;
            for (char c : arr) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (Character key : map.keySet()) {
                Integer i = map.get(key);
                pq.add(new Node(key, i));
            }

            if (size % 2 == 1 && pq.peek().cnt > size / 2 + 1) {
                return "";
            }

            if (size % 2 == 0 && pq.peek().cnt > size / 2) {
                return "";
            }
        }

        char[] ans = new char[size];
        int idx = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (int i = 0; i < node.cnt; i++) {
                ans[idx] = node.c;
                idx = idx + 2;
                if (idx >= size) {
                    idx %= size;
                    if (idx % 2 == 0) {
                        idx++;
                    }
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