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
    public int maxDepth(TreeNode root) {
        return go(root,0,0);
    }
    
    private int go(TreeNode node, int depth, int ans) {
        if (node == null) {
            return depth;
        }
        
        ans = Math.max(ans, go(node.left, depth+1, ans));
        ans = Math.max(ans, go(node.right, depth+1, ans));
        
        return ans;
    }
}