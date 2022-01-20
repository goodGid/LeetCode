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
    public int rob(TreeNode root) {
        int[] ans = helper(root);
        return Math.max(ans[0], ans[1]);
    }
    
    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[] {0,0};
        }
        
        int[] dp = new int[2];
        int[] a = helper(node.left);
        int[] b = helper(node.right);
        
        dp[0] = node.val + a[1] + b[1];
        dp[1] = Math.max(a[0], a[1]) + Math.max(b[0], b[1]);
        return dp;
    }
}