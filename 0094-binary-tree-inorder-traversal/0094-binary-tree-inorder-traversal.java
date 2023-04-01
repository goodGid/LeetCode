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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        TreeNode node = new TreeNode();
        node = root;
        while (node != null) {
            st.add(node);
            node = node.left;
        }
        
        while (!st.isEmpty()) {
            TreeNode top = st.pop();
            list.add(top.val);
            
            top = top.right;
            while (top != null) {
                st.add(top);
                top = top.left;
            }
        }
        
        return list;
    }
}