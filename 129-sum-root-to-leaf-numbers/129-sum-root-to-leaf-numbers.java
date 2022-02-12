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
    int ans;
    
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    
    private void dfs(TreeNode node, int sum) {
        if (node == null) {
            return ;
        }
        
        sum *= 10;
        
        if (node.left == null && node.right == null) {
            ans = ans + sum + node.val;
            return;
        }
        
        dfs(node.left, sum + node.val);
        dfs(node.right, sum + node.val);
    }
}