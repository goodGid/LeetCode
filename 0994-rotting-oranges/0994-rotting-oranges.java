class Solution {
    public int orangesRotting(int[][] map) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int n = map.length;
        int m = map[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        int freshCnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 1) {
                    freshCnt++;
                }
                if (map[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
            }
        }
        
        int cnt = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            if (size > 0) {
                cnt++;
            }
            
            for (int i=0; i<size; i++) {
                int[] node = q.poll();
                int x = node[0];
                int y = node[1];
                
                for (int k=0; k<4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    
                    if (!isFresh(map, nx, ny)) {
                        continue;
                    }
                    freshCnt--;
                    map[nx][ny] = 2;
                    q.add(new int[] {nx, ny});
                }
            }
        }
        if (freshCnt == 0 && cnt == -1) {
            return 0;
        }
        if (freshCnt == 0) {
            return cnt;
        }
        return -1;
    }
    
    private boolean isFresh(int[][] map, int x, int y) {
        int n = map.length;
        int m = map[0].length;
        
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return false;
        }
        
        if (map[x][y] != 1) {
            return false;
        }
        
        return true;
    }
    
    private void print(int[][] map) {
        int n = map.length;
        int m = map[0].length;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println();
    }
}