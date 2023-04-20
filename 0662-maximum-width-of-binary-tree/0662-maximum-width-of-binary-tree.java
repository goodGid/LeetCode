// ref : https://leetcode.com/submissions/detail/936641796

class Solution {

    static class TreeNodeWrapper{
        long idx;
        TreeNode treeNode;
        public TreeNodeWrapper(long idx, TreeNode treeNode){
            this.idx = idx;
            this.treeNode = treeNode;
        }
    }


    public int widthOfBinaryTree(TreeNode root) {
        int maxCount = -2000000000;
        if(root == null)
            return 0;
        TreeNodeWrapper treeNodeWrapper = new TreeNodeWrapper(1, root);
        Queue<TreeNodeWrapper> q = new LinkedList<>();
        q.add(treeNodeWrapper);
        while(!q.isEmpty()){
            int curIter = q.size();
            long curMin = Long.MAX_VALUE;
            long curMax = Long.MIN_VALUE;
            while(curIter-- > 0){
                TreeNodeWrapper curNodeWrapper = q.poll();
                long curIdx = curNodeWrapper.idx;
                TreeNode curNode = curNodeWrapper.treeNode;
                curMin = Math.min(curMin, curIdx);
                curMax = Math.max(curMax, curIdx);
                if(curNode.left != null)
                    q.add(new TreeNodeWrapper(2*curIdx-1, curNode.left));
                if(curNode.right != null)
                    q.add(new TreeNodeWrapper(2*curIdx, curNode.right));
            }
            maxCount = Math.max(maxCount, (int)(curMax-curMin+1));
        }
        return maxCount;
    }
}