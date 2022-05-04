class Solution {
    public int[] nextGreaterElement(int[] n1, int[] n2) {
        int n1l = n1.length;
        int n2l = n2.length;
        int[] ans = new int[n1l];
        int[] dp = new int[10001];

        Arrays.fill(dp, -1);

        for (int i = 0; i < n2l - 1; i++) {
            for (int j = i + 1; j < n2l; j++) {
                if (n2[i] < n2[j]) {
                    dp[n2[i]] = n2[j];
                    break;
                }
            }
        }

        for (int i = 0; i < n1l; i++) {
            ans[i] = dp[n1[i]];
        }

        return ans;
    }
}
