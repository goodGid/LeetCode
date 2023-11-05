class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0 ;
        for(int i : nums){
            if(map.containsKey(i)){
                count+=map.get(i);
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
        return count;
    }
}