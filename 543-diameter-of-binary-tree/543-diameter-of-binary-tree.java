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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{-1, -1};
        }
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        int maxLeft = Math.max(left[0], left[1]) + 1;
        int maxRight = Math.max(right[0], right[1]) + 1;
        
        ans = Math.max(ans, maxLeft + maxRight);
        
        return new int[]{maxLeft, maxRight};
    }
}