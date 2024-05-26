class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        List<int[]> list = new LinkedList<>();
        int[][] visit = new int[matrix.length][matrix[0].length];
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0;
        
        list.add(new int[]{0,0});
        
        while(!list.isEmpty()) {
            int[] node = list.get(0);
            int x = node[0];
            int y = node[1];
            list.remove(0);
            visit[x][y] = 1;
            ans.add(matrix[x][y]);
            
            for (int i=0; i<=1; i++) {
                dir = (dir+i) % 4;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if (isRange(matrix, nx, ny)) {
                    if (visit[nx][ny] == 0) {
                        list.add(new int[]{nx, ny});
                        break;
                    }
                }
            }
        }
        return ans;
    }
    
    private boolean isRange(int[][] map, int x, int y) {
        int xLen = map.length;
        int yLen = map[0].length;
        
        if (x >= 0 && x < xLen && y >= 0 && y < yLen) {
            return true;
        }
        return false;
    }
}