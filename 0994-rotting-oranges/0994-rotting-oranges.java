class Solution {
    public int orangesRotting(int[][] grid) {
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        int row = grid.length;
        int col = grid[0].length;
        int[][] visit = new int[row][col];
        int orange_cnt = 0;
        int time = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    orange_cnt++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            boolean isWork = false;
            for (int s = 0; s < size; s++) {
                int[] node = q.poll();
                int x = node[0];
                int y = node[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (isAccess(nx, ny, grid, visit)) {
                        isWork = true;
                        orange_cnt--;
                        visit[nx][ny] = 1;
                        q.add(new int[] { nx, ny });
                    }
                }
            }
            if (isWork) {
                time++;
            }
        }

        if (orange_cnt == 0) {
            return time;
        } else {
            return -1;
        }
    }

    private boolean isAccess(int x, int y, int[][] grid, int[][] visit) {
        int row = grid.length;
        int col = grid[0].length;

        if (x < 0 || x >= row || y < 0 || y >= col) {
            return false;
        }

        if (visit[x][y] == 1) {
            return false;
        }

        if (grid[x][y] != 1) {
            return false;
        }
        return true;
    }
}