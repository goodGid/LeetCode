class Solution {
    public static HashMap<Integer, Integer> depthMap;
    public static HashMap<Integer, TreeNode> parentMap;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //노드별 depth, 부모노드 계산
        depthMap = new HashMap<>();
        parentMap = new HashMap<>();
        calc(root, 0);

        //p와 q 높이 맞추기
        while (true) {
            //같은 경우 break
            if (depthMap.get(p.val) == depthMap.get(q.val)) {break;} else if (depthMap.get(p.val)
                                                                              > depthMap.get(q.val)) {
                //p의 깊이가 더 큰경우
                p = parentMap.get(p.val);
            } else {
                q = parentMap.get(q.val);
            }
        }

        //한칸씩 올라가며 값이 같을때까지
        while (true) {
            if (p.val == q.val) {break;} else {
                p = parentMap.get(p.val);
                q = parentMap.get(q.val);
            }
        }

        return p;
    }

    private void calc(TreeNode root, int depth) {
        depthMap.put(root.val, depth);
        if (root.left != null) {
            calc(root.left, depth + 1);
            parentMap.put(root.left.val, root);
        }

        if (root.right != null) {
            calc(root.right, depth + 1);
            parentMap.put(root.right.val, root);
        }
    }
}
