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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        
        if (p != null) {
            q1.add(p);
        }
        
        if (q != null) {
            q2.add(q);
        }
        
        List<Integer> list = new ArrayList<>();
        while (!q1.isEmpty()) {
            TreeNode node = q1.poll();
            
            if (node == null) {
                list.add(10005);
                continue;
            } else {
                list.add(node.val);
            }
            
            q1.add(node.left);
            q1.add(node.right);
        }
        
        List<Integer> list2 = new ArrayList<>();
        while (!q2.isEmpty()) {
            TreeNode node = q2.poll();
            
            if (node == null) {
                list2.add(10005);
                continue;
            } else {
                list2.add(node.val);
            }
            
            q2.add(node.left);
            q2.add(node.right);
        }
        
        if (list.size() != list2.size()) {
            return false;
        }
        
        int size = list.size();
              
        for (int i=0; i<size; i++) {
            if (!Objects.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        
        return true;
        
    }
}