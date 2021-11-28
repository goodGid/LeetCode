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
    public List<Integer> rightSideView(TreeNode root) {
        if ( root == null ) {
            return new ArrayList<>();
        }
        
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> treeLevelGroup = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            List<Integer> list = new ArrayList<>();
            
            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);               
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            treeLevelGroup.add(list);
        }
        
        int depth = treeLevelGroup.size();
        for (int i=0; i<depth; i++) {
            int size = treeLevelGroup.get(i).size();
            ans.add(treeLevelGroup.get(i).get(size-1));
        }
    
        return ans;
    }
}