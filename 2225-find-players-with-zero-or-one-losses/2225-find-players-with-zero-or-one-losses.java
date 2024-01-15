class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int[] item : matches) {
            int winner = item[0];
            int loser = item[1];
            
            if (!map.containsKey(winner)) {
                map.put(winner, new ArrayList<>());
            }
            if (!map.containsKey(loser)) {
                map.put(loser, new ArrayList<>());
            }
            List<Integer> losers = map.get(loser);
            losers.add(winner);
        }
        
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        
        for (Integer key : map.keySet()) {
            List<Integer> values = map.get(key);
            if (values.size() == 0) {
                ans.get(0).add(key);
            } else if (values.size() == 1) {
                ans.get(1).add(key);
            }
        }

        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        
        return ans;
    }
}