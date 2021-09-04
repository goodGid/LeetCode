class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        transpose(matrix, n);
        reflect(matrix, n);
    }

    public void transpose(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public void reflect(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= n / 2; j--) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][n - j - 1];
                arr[i][n - j - 1] = temp;
            }
        }
    }
}