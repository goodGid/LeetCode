class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            fast = findSquaredSum(findSquaredSum(fast));
            slow = findSquaredSum(slow);
        } while (fast != slow);
        return slow == 1;
    }

    private int findSquaredSum(int n) {
        int squaredSum = 0;
        while (n != 0) {
            int r = n % 10;
            squaredSum += (int) Math.pow(r, 2);
            n /= 10;
        }
        return squaredSum;
    }
}