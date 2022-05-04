class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        PriorityQueue<Node> node1 = new PriorityQueue<>();
        PriorityQueue<Node> node2 = new PriorityQueue<>();

        for (int i = 0; i < trips.length; i++) {
            node1.add(new Node(trips[i][1], trips[i][0]));
            node2.add(new Node(trips[i][2], trips[i][0]));
        }

        int sum = 0;
        while (!node1.isEmpty()) {
            int stVal = node1.peek().pos;
            int endVal = node2.peek().pos;

            if (stVal < endVal) {
                Node node = node1.poll();
                if (sum + node.cap <= capacity) {
                    sum += node.cap;
                } else {
                    return false;
                }
            } else {
                Node node = node2.poll();
                sum -= node.cap;
            }
        }

        return true;

    }

    class Node implements Comparable<Node> {
        int pos;
        int cap;

        public Node(int pos, int cap) {
            this.pos = pos;
            this.cap = cap;
        }

        @Override
        public int compareTo(Node newNode) {
            return pos - newNode.pos;
        }
    }
}