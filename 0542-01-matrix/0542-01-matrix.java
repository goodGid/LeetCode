class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                } else {
                    q.add(new Pair(i,j));
                }
            }
        }        
        
        while (!q.isEmpty()) {
            Pair<Integer, Integer> node = q.poll();
            int x = node.getKey();
            int y = node.getValue();
            
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!isRange(n,m,nx,ny)) {
                    continue;
                }
                if (mat[nx][ny] == - 1) {
                    mat[nx][ny] = mat[x][y] + 1;
                    q.add(new Pair(nx,ny));
                }
            }            
        }
     
        return mat;
    }
    
    private boolean isRange(int n, int m, int x, int y) {
        if (x<0 || x>=n || y <0 || y >= m)  {
            return false;
        }
        return true;
    }
}