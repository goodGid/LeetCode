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
        int cnt = 0;
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        st.add(root);
        
        while (true) {
            while (cur.left != null) {
                st.add(cur.left);
                cur = cur.left;
            }
            
            while (!st.isEmpty()) {
                cur = st.pop();
                
                if (cnt+1 == k) {
                    return cur.val;
                }
                cnt++;
                
                if (cur.right != null) {
                    st.add(cur.right);
                    cur = cur.right;
                    break;
                }
            }            
        }
    }
}