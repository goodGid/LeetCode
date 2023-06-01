class Solution {
    int[] dx = { 1, 0, 0, -1, -1, -1, 1, 1 };
    int[] dy = { 0, 1, -1, 0, -1, 1, -1, 1 };
    int size;
    int[][] grid;
    int[][] visit;

    public int shortestPathBinaryMatrix(int[][] _grid) {
        size = _grid.length;
        grid = _grid;
        visit = new int[size][size];

        if (_grid[0][0] == 1) {
            return -1;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        visit[0][0] = 1;

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                int[] top = q.poll();
                int x = top[0];
                int y = top[1];

                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (isAccessible(nx, ny)) {
                        visit[nx][ny] = visit[x][y] + 1;
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }

        if (visit[size - 1][size - 1] == 0) {
            return -1;
        }
        return visit[size - 1][size - 1];
    }

    private boolean isAccessible(int x, int y) {
        if (x < 0 || x >= size || y < 0 | y >= size) {
            return false;
        }
        if (grid[x][y] == 1) {
            return false;
        }
        if (visit[x][y] != 0) {
            return false;
        }
        return true;
    }
}