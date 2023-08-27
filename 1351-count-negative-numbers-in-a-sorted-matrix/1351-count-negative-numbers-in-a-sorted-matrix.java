class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int x = -1;
        int y = -1;
        for (int i=n-1; i>=0; i--) {
            for (int j=m-1; j>=0; j--) {
                if (grid[i][j] < 0 ) {
                    x = i;
                    y = j;
                    break;
                }
            }
            if (x != -1) {
                break;
            }
        }
        
        if (x == -1) {
            return 0;
        }
        
        int x2 = x;
        int y2 = y;
                
        for (int j=y; j>=0; j--) {
            if (grid[x][j] > 0) {
                break;
            }
            y2 = j;
        }
        
        for (int i=x; i>=0; i--) {
            if (grid[i][y] > 0) {
                break;
            }
            x2 = i;
        }

        int cnt = 0;
        for (int i=x2; i<n; i++) {
            for (int j=y2; j<m; j++) {
                if (grid[i][j] < 0 ) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}