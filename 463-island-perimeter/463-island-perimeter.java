class Solution {
    public int islandPerimeter(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] visit = new int[row][col];
        
        int[] dx = new int[] {1,-1,0,0};
        int[] dy = new int[] {0,0,1,-1};
        
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Node(i,j));
                    visit[i][j] = 1;
                    break;
                }
            }
        }
            
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i=0; i<4; i++) {
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;
                
                if (!isRange(grid, nx,ny)) {
                    ans++;
                } else if (grid[nx][ny] == 0) {
                    ans++;
                } else if (grid[nx][ny] == 1 && visit[nx][ny] == 0) {
                    visit[nx][ny] = 1;
                    q.add(new Node(nx,ny));
                }
            }   
        }
        return ans;
    }
    
    private boolean isRange(int[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        
        if (x < 0 || x >= row) {
            return false;
        }
        if (y < 0 || y >= col) {
            return false;
        }
        return true;
    }
    
    public class Node {
        int x;
        int y;
        public Node(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
}