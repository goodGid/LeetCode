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
        go(ans, root);
        return ans;
    }
    
    public List<Integer> go(List<Integer> ans, TreeNode node) {
        if (node == null) {
            return null;
        }
        
        go(ans, node.left);
        ans.add(node.val);
        go(ans, node.right);
        
        return ans;
    }
}