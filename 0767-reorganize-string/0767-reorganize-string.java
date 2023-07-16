class Solution {
    public String reorganizeString(String s) {
        if (s.length() == 1) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (Character key : map.keySet()) {
            pq.add(new Node(key, map.get(key)));
        }

        int idx = 0;
        char[] chars = new char[s.length()];
        while (pq.size() > 1) {
            Node node1 = pq.poll();
            Node node2 = pq.poll();

            if (idx == 0) {
                chars[idx] = node1.getVal();
                idx++;
                if (node1.getCnt() - 1 > 0) {
                    pq.add(new Node(node1.getVal(), node1.getCnt() - 1));
                }
                pq.add(node2);
                continue;
            }

            if (chars[idx - 1] == node1.getVal()) {
                chars[idx] = node2.getVal();
                idx++;
                if (node2.getCnt() - 1 > 0) {
                    pq.add(new Node(node2.getVal(), node2.getCnt() - 1));
                }
                pq.add(node1);
            } else {
                chars[idx] = node1.getVal();
                idx++;
                if (node1.getCnt() - 1 > 0) {
                    pq.add(new Node(node1.getVal(), node1.getCnt() - 1));
                }
                pq.add(node2);
            }
        }

        Node lastNode = pq.poll();
        
        if (lastNode.getCnt() > 1) {
            return "";
        } else if (chars[idx - 1] == lastNode.getVal()) {
            return "";
        } else {
            chars[idx] = lastNode.getVal();
        }

        return String.valueOf(chars);
    }
}

class Node implements Comparable<Node> {
    private char val;
    private int cnt;

    public Node(char val, int cnt) {
        this.val = val;
        this.cnt = cnt;
    }

    public char getVal() {
        return val;
    }

    public int getCnt() {
        return cnt;
    }

    @Override
    public int compareTo(Node newNode) {
        return newNode.cnt - cnt; // 내림차순
    }
}
