class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Node[] nodes = new Node[41];
        for (int i = 1; i <= target; i++) {
            nodes[i] = new Node(i);
        }

        for (int candidate : candidates) {
            for (int i = candidate; i <= target; i++) {
                if (i == candidate) {
                    Node node = nodes[candidate];
                    node.add(Collections.singletonList(candidate));
                    continue;
                }
                List<List<Integer>> subList = nodes[i - candidate].getList();
                if (subList.isEmpty()) {
                    continue;
                }

                for (List<Integer> sub : subList) {
                    List<Integer> list = new ArrayList<>();
                    list.add(candidate);
                    for (int val : sub) {
                        list.add(val);
                    }
                    nodes[i].add(list);
                }
            }
        }
        return nodes[target].getList();
    }

    class Node {
        int val;
        List<List<Integer>> list = new ArrayList<>();

        public Node(int _val) {
            this.val = _val;
        }

        public void add(List<Integer> subList) {
            this.list.add(subList);
        }

        public List<List<Integer>> getList() {
            return this.list;
        }
    }
}