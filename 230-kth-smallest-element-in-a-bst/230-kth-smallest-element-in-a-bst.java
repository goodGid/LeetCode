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
        List<Integer> list = new ArrayList<>();
        recur(root, list);
        return list.get(k-1);
    }
    
    private void recur(TreeNode node, List<Integer> list) {
        if (node == null) {
            return ;
        }
        
        recur(node.left, list);
        list.add(node.val);
        recur(node.right, list);
    }
    
}