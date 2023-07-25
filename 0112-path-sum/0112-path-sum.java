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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
                
        boolean hasChild = false;
        if (root.left != null || root.right != null) {
            hasChild = true;
        }
        
        return dfs(root, targetSum, 0, hasChild);
    }
    
    private boolean dfs(TreeNode node, int t, int sum, boolean hasChild) {
        if (node == null) {
            if (hasChild == false && t == sum) {
                return true;
            }
            return false;
        }
        
        hasChild = false;
        if (node.left != null || node.right != null) {
            hasChild = true;
        }
        
        boolean isSame = false;
        isSame = dfs(node.left, t, sum + node.val, hasChild);
        if (isSame) {
            return true;
        }
        isSame = dfs(node.right, t, sum + node.val, hasChild);
        if (isSame) {
            return true;
        }
        return false;
    }
}