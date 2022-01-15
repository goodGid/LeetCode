class Solution {
    public int longestConsecutive(int[] n) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i : n) {
            map.put(i, true);
        }

        int ans = 0;

        for (Map.Entry<Integer, Boolean> item : map.entrySet()) {
            int curNumber = item.getKey();
            
            if (map.get(curNumber - 1) == null) {
                int conCnt = 1;
                

                while (map.get(curNumber + 1) != null) {
                    conCnt++;
                    curNumber++;
                }
                ans = Math.max(ans, conCnt);
            }
        }
        return ans;
    }
}