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
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        go(root, k, list);
        return list.get(k-1).val;
    }
    
    private void go(TreeNode node, int k, List<TreeNode> list) {
        if (node == null) {
            return ;
        }
        go(node.left, k, list);
        list.add(node);
        go(node.right, k, list);
    }
}