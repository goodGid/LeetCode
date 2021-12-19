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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return go(preorder, inorder, 
           0, preorder.length-1,
           0, inorder.length-1);

    }
    
    private TreeNode go(int[] preorder, int[] inorder, 
                        int preLeftIdx, int preRightIdx, 
                        int inLeftIdx, int inRightIdx) {
        
        if (preLeftIdx > preRightIdx) {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preLeftIdx]);
        
        int range = 0;
        for (int i = inLeftIdx; i<=inRightIdx; i++) {
            if (inorder[i] == node.val) {
                range = i - inLeftIdx;
            }
        }
        
        node.left = go(preorder, inorder,
                      preLeftIdx+1, preLeftIdx + range,
                      inLeftIdx, inLeftIdx + range - 1);
        node.right = go(preorder, inorder,
                       preLeftIdx+1+range, preRightIdx,
                       inLeftIdx+1+range, inRightIdx);
        
        return node;
    }
}