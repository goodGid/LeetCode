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
        if (root == null){
            return 0;
        }
        
        return getMaxDepth(root, 1);
    }
    
    public int getMaxDepth(TreeNode node, int ans){
        if(node == null){
            return ans;
        }
        
        int leftMaxDepth =0;
        int rightMaxDepth = 0;
        
        if (node.left != null){
            leftMaxDepth = getMaxDepth(node.left, ans+1);
            System.out.println("leftMaxDepth : " + leftMaxDepth);
        }
        
        if (node.right != null){
            rightMaxDepth = getMaxDepth(node.right, ans+1);
            System.out.println("rightMaxDepth : " + rightMaxDepth);
        }
        
        ans = Math.max(ans, Math.max(leftMaxDepth,rightMaxDepth));
        
        return ans;
    }
}