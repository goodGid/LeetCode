class Solution {
    public int[] replaceElements(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int[] ans = new int[arr.length];

        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int i = 1; i < arr.length; i++) {
            queue.add(new Node(i, arr[i]));
        }

        ans[0] = queue.peek().value;
        ans[arr.length-1] = -1;
        int ansIdx = 1;

        while (!queue.isEmpty()) {
            Node node = queue.peek();
            if (ansIdx >= node.index) {
                queue.poll();
                continue;
            }
            ans[ansIdx] = queue.peek().value;
            ansIdx++;
        }

        return ans;
    }

    public class Node implements Comparable<Node> {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node newNode) {
            return newNode.value - value;
        }
    }
}