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
        return solve(nums, 0, nums.length - 1);
    }

    public TreeNode solve(int[] nums, int stIdx, int endIdx) {
        int midIdx = (stIdx + endIdx) / 2;

        TreeNode node = new TreeNode(nums[midIdx]);
        if (stIdx <= midIdx - 1) {
            node.left = solve(nums, stIdx, midIdx - 1);
        }
        if (midIdx + 1 <= endIdx) {
            node.right = solve(nums, midIdx + 1, endIdx);
        }

        return node;
    }
}