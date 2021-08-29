class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.computeIfPresent(nums[i], (key, value) -> {
                    return value + 1;
                });
            } else {
                map.put(nums[i], 1);
            }
        }

        List<Node> nodeList = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            nodeList.add(new Node(key, value));
        }

        List<Node> sortedNodeList = nodeList.stream()
                                            .sorted((a, b) -> b.value - a.value)
                                            .limit(k)
                                            .collect(Collectors.toList());

        int[] ans = new int[k];
        for (int i = 0; i < sortedNodeList.size(); i++) {
            ans[i] = sortedNodeList.get(i).key;
        }
        return ans;
    }

    public class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}
