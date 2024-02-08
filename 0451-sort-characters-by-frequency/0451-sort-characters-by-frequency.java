class Solution {
    public String frequencySort(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        List<Node> list = new ArrayList<>();

        for (char c : cs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char key : map.keySet()) {
            int cnt = map.get(key);
            list.add(new Node(key, cnt));
        }

        list.sort((l1, l2) -> l2.cnt - l1.cnt);

        StringBuffer sb = new StringBuffer();
        for (Node node : list) {
            for (int i = 0; i < node.cnt; i++) {
                sb.append(node.key);
            }
        }
        return sb.toString();
    }

    class Node {
        char key;
        int cnt = 0;

        public Node(char _key, int cnt) {
            this.key = _key;
            this.cnt = cnt;
        }
    }
}