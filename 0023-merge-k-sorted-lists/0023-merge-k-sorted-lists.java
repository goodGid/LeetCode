class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.val - n2.val;
        });

        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            pq.add(new Node(node.val, node.next));
        }

        ListNode ans = new ListNode();
        ListNode ptr = ans;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            ptr.next = new ListNode(node.val);
            ptr = ptr.next;

            if (node.listNode == null) {
                continue;
            } else {
                pq.add(new Node(node.listNode.val, node.listNode.next));
            }
        }

        return ans.next;
    }

    class Node {
        int val;
        ListNode listNode;

        public Node(int _val, ListNode _node) {
            val = _val;
            listNode = _node;
        }

        public int getVal() {
            return val;
        }

        public ListNode getListNode() {
            return listNode;
        }
    }
}