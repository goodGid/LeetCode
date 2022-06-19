/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Integer, Node> map = new HashMap<>();
        int[] visit = new int[101];
        Queue<Node> q = new LinkedList<>();

        Node root = new Node(node.val);
        map.put(node.val, root);
        q.add(node);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            visit[temp.val] = 1;
            Node clonedNode = map.get(temp.val);

            List<Node> neighbors = temp.neighbors;
            for (Node neighbor : neighbors) {
                if (visit[neighbor.val] == 0) {
                    Node newNode = new Node(neighbor.val);
                    map.put(newNode.val, newNode);
                    visit[newNode.val] = 1;
                    clonedNode.neighbors.add(newNode);
                    q.add(neighbor);
                } else {
                    Node newNode = map.get(neighbor.val);
                    clonedNode.neighbors.add(newNode);
                }
            }
        }
        return root;
    }
}