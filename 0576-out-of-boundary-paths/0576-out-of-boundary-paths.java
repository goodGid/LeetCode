class Solution {
    int n;
    int m;
    int[][][] dp;
    int[] dx = {1,-1, 0, 0};
    int[] dy = {0, 0, 1,-1};
    int mod = (int) 1e9 + 7;
    
    public int findPaths(int _m, int _n, int maxMove, int startRow, int startColumn) {
        n = _m;
        m = _n;
        
        dp = new int[n][m][maxMove+1];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                for (int k=0; k<=maxMove; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        go(startRow, startColumn, maxMove);
        
        if (dp[startRow][startColumn][maxMove] == -1) { 
            return 0;
        }
        return dp[startRow][startColumn][maxMove];
    }
    
    private int go(int x, int y, int mvCnt) {
        if (mvCnt == 0) {
            return 0;
        }
        if (dp[x][y][mvCnt] != -1) {
            return dp[x][y][mvCnt];
        }
        
        int cnt = 0;
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (!isRange(nx,ny)) {
                cnt++;
            } else {
                cnt += (go(nx, ny, mvCnt-1) % mod);
                cnt %= mod;
            }
        }
            
        return dp[x][y][mvCnt] = cnt;
    }
    
    private boolean isRange(int x, int y) {
        if (x < 0 || x == n || y < 0 || y == m) {
            return false;
        }
        return true;
    }
}