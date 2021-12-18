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
    public void flatten(TreeNode root) {
        
        while ( root != null) {
            TreeNode temp = root.right;
            
            if (root.left != null) {
                root.right = root.left;
                TreeNode head = root.right;
                
                while (head.right != null) {
                    head = head.right;
                }
                head.right = temp;
            }
            root.left = null;
            root = root.right;
        }
    }
}