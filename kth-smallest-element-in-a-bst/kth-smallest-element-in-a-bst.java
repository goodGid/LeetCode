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
    int depth = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        
        go(root,k);
        
        return ans;
    }
    
    private void go(TreeNode head, int k) {
        
        if (head.left != null) {
            go(head.left, k);
        }
        
        depth++;        
        print(head);
        if (depth == k) {
            ans = head.val;
        }   
        
        if (head.right != null) {
            go(head.right, k);
        }
    }
    
    private void print(TreeNode node) {
        System.out.println(node.val + " " + depth);
    }
    
}