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
        return find(0, root);
    }

    public int find(int depth, TreeNode node) {
        if (node == null) {
            return depth;
        }
        return Math.max(find(depth + 1, node.left), find(depth + 1, node.right));
    }
    
    
}