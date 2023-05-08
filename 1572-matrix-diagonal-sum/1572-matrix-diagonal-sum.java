class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int size = mat[0].length;
        for (int i=0; i<size; i++)  {
            System.out.println(mat[i][i]);
            sum += mat[i][i];
        }

        int row = 0;
        for (int i=size-1; i>=0; i--)  {
            System.out.println(mat[i][i]);
            sum += mat[row++][i];
        }
        
        if (size % 2 == 1) {
            sum -= mat[size/2][size/2];
        }
        
        return sum;
        
    }
}