// 240309 : 다른 사람 코드보다 궁금해서 제출

class Solution {
    public int search(int[] nums, int target) {
        int index = -1;
        int minValue = 100000;
        int minIndex = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target) index = i;
        }
        return index;
    }
}