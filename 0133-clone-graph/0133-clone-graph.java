// 240128 : 문제 자체가 이해 안 됨...
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {return node;}

        Map<Node, Node> map = new HashMap<>();

        return cloneGraph(node, map);
    }

    private Node cloneGraph(Node node, Map<Node, Node> map) {

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);

        for (Node neigh : node.neighbors) {
            Node cloneNeigh = cloneGraph(neigh, map);
            cloneNode.neighbors.add(cloneNeigh);
        }

        return cloneNode;
    }
}