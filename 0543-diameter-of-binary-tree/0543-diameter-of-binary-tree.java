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
    int ans = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return Math.max(dfs(root.left,1) + dfs(root.right,1), ans);
    }
    
    private int dfs(TreeNode node, int level) {
        if (node == null) {
            return level - 1;
        }
        int left = dfs(node.left, level+1);
        int right = dfs(node.right, level+1);
        ans = Math.max(ans, (left-level) + (right-level));
        
        return Math.max(left, right);
    }
}