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
class BSTIterator {
    Queue<Integer> q;

    public BSTIterator(TreeNode root) {
        q = new LinkedList<>();
        inOrder(q, root);
    }
    
    public int next() {
        return q.poll();
        
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
        
    }
    
    private void inOrder(Queue<Integer> tempQ, TreeNode node) {
        if (node == null) {
            return ;
        }
        inOrder(tempQ, node.left);
        tempQ.add(node.val);
        inOrder(tempQ, node.right);     
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */