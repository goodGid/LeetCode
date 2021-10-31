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
    public TreeNode sortedArrayToBST(int[] nums) {
        return go(nums,0,nums.length-1);
    }
    
    private TreeNode go(int[] nums, int left, int right) {
        int mid = (left+right) / 2;
        
        TreeNode node = new TreeNode(nums[mid]);
        
        if (left <= mid-1) {
            node.left = go(nums, left, mid-1);
        }
        if (mid+1 <= right) {
            node.right = go(nums, mid+1, right);
        }
        return node;
    }
}