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
    public int maxAncestorDiff(TreeNode root) {
        return go(root, root.val, root.val);
    }
    
    
    private int go(TreeNode node, int maxVal, int minVal) {
        int val = node.val;
        int ans = (int)Math.abs(maxVal - val);
        ans = Math.max(ans, (int)Math.abs(minVal - val));
        maxVal = Math.max(maxVal, val);
        minVal = Math.min(minVal, val);
        
        if (node.left != null) {
            int leftMaxVal = go(node.left, maxVal, minVal);
            ans = Math.max(ans, leftMaxVal);
        }
        
        if (node.right != null) {
            int rightMaxVal = go(node.right, maxVal, minVal);
            ans = Math.max(ans, rightMaxVal);
        }
        
        return ans;
    }
}