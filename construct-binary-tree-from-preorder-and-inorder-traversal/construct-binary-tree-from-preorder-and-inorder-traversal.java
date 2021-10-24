class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recur(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1);
    }

    private TreeNode recur(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inorderRootIdx = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (preorder[preStart] == inorder[i]) {
                inorderRootIdx = i;
                break;
            }
        }

        int subLength = inorderRootIdx - inStart;

        root.left = recur(preorder, preStart + 1, preStart + subLength,
                          inorder, inStart, inStart + subLength);

        root.right = recur(preorder, preStart + subLength + 1, preEnd,
                           inorder, inorderRootIdx + 1, inEnd);
        return root;

    }

}