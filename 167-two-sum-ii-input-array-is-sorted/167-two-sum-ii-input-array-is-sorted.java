class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[0];

        for (int i = 0; i < numbers.length; i++) {

            int result = Arrays.binarySearch(numbers, target - numbers[i]);

            if (i == result) {
                continue;
            }

            if (result >= 0) {
                if (i > result) {
                    ans = new int[] { result + 1, i + 1 };
                } else {
                    ans = new int[] { i + 1, result + 1 };
                }
                break;
            }
        }

        return ans;
    }
}