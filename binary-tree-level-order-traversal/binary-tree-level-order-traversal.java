/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if (root == null) {
            return new ArrayList<>();
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int depthSize = 0;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            List<Integer> list = map.getOrDefault(node.depth, new ArrayList<>());
            list.add(node.treeNode.val);
            map.put(node.depth, list);
            
            if (node.treeNode.left != null) {
                q.add(new Node(node.treeNode.left, node.depth + 1));
            }
            
            if (node.treeNode.right != null) {
                q.add(new Node(node.treeNode.right, node.depth + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        int idx = 0;
        while (true) {
            if (!map.containsKey(idx)){
                break;
            }
            ans.add(new ArrayList(map.get(idx++)));
        }
        
        return ans;
    }
    
    class Node {
        private TreeNode treeNode;
        private int depth;
        
        public Node(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }
}