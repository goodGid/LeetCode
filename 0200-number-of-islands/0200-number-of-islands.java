class Solution {
    public int numIslands(char[][] _grid) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        int n = _grid.length;
        int m = _grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int[][] grid = new int[n][m];
        int[][] visit = new int[n][m];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                grid[i][j] = _grid[i][j] - '0';
                if (grid[i][j] == 1) {
                    q.add(new int[]{i,j});
                }
            }
        }
        
        // for (int i=0; i<n; i++) {
        //     for (int j=0; j<m; j++) {
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        
        int cnt = 2;
        
        while (!q.isEmpty()) {
            int[] _node = q.poll();
            int _x = _node[0];
            int _y = _node[1];
            
            if (grid[_x][_y] != 1) {
                continue;
            }
            grid[_x][_y] = cnt;
            Queue<int[]> q2 = new LinkedList<>();
            q2.add(new int[] {_x,_y});
            
            while (!q2.isEmpty()) {
                int[] node = q2.poll();
                int x = node[0];
                int y = node[1];            
                
                for (int i=0; i<4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (!isLand(grid, nx, ny)) {
                        continue;
                    }           
                    grid[nx][ny] = cnt;
                    q2.add(new int[] {nx, ny});
                }
            }
            cnt++;
        }
        
        // for (int i=0; i<n; i++) {
        //     for (int j=0; j<m; j++) {
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        
        return cnt - 2;
    }
    
    private boolean isLand(int[][] map, int x, int y) {
        int n = map.length;
        int m = map[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        
        if (map[x][y] == 0 || map[x][y] != 1) {
            return false;
        }
        
        return true;
    }
}