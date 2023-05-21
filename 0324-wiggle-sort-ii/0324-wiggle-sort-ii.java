// from Solution 

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int j = nums.length - 1;
        int i = 1;
        while (j >= 0) {
            if (i > nums.length - 1) {
                i = 0;
            }
            res[i++] = nums[j--];
            i++;
        }
        for (i = 0; i < res.length; i++) {
            nums[i] = res[i];
        }
    }
}