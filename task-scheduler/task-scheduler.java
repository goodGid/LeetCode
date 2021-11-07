class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        int[] arr = new int[26];

        for (int i = 0; i < len; i++) {
            arr[tasks[i] - 'A']++;
        }

        int max = arr[0];
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        for (int i = 0; i < 26; i++) {
            if (max == arr[i]) {
                count++;
            }
        }
        return Math.max(len, (max - 1) * (n + 1) + count);
    }
}