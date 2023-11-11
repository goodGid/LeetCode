class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = adjacentPairs.length + 1;
        int[] ans = new int[n];
        int idx = 0;
        
        for (int i=0; i<n-1; i++) {
            int left = adjacentPairs[i][0];
            int right = adjacentPairs[i][1];

            map.computeIfAbsent(left, k -> new ArrayList<>()).add(right);
            map.computeIfAbsent(right, k -> new ArrayList<>()).add(left);
            
            // List<Integer> value = map.getOrDefault(left, new ArrayList<>());
            // value.add(right);
            // map.put(left, map.getOrDefault(left, value));
            // value = map.getOrDefault(right, new ArrayList<>());
            // value.add(left);
            // map.put(right, map.getOrDefault(right, value));
        }
        
        int target = -1;
        
        for (Integer key : map.keySet()) {
            if (map.get(key).size() == 1) {
                target = key;
                break;
            }
        }
        
        Map<Integer, Boolean> isVisit = new HashMap<>();
        while (idx < n) {
            ans[idx++] = target;
            isVisit.put(target, true);
            List<Integer> list = map.get(target);
            for (int i: list) {
                if (isVisit.getOrDefault(i,false) == false) {
                    target = i;
                    break;
                }
            }
        }

        return ans;
    }
}