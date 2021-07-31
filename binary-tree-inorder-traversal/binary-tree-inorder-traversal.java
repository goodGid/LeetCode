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
    public List<Integer> inorderTraversal(TreeNode root) {        
        
        List<Integer> ans = new ArrayList<>();
        
        if (root != null) {
            inOrder(ans, root);
        }
        return ans;
    }
    
    public void inOrder(List<Integer> ans, TreeNode node) {
        if (node.left != null) {
            inOrder(ans, node.left);
        }
        ans.add(node.val);
        
        if (node.right != null) {
            inOrder(ans, node.right);
        }
    }
    
}