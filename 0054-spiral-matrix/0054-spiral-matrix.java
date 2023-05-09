class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        List<Integer> ans = new ArrayList<>();

        int x = 0;
        int y = 0;
        int dir = 0;
        while (true) {
            if (!isRange(matrix, x, y)) {
                break;
            }

            ans.add(matrix[x][y]);
            matrix[x][y] = -101;
            if (isRange(matrix, x + dx[dir], y + dy[dir])) {
                x += dx[dir];
                y += dy[dir];
            } else {
                dir = (dir + 1) % 4;
                x += dx[dir];
                y += dy[dir];
            }
        }

        return ans;
    }

    private boolean isRange(int[][] map, int x, int y) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
            return false;
        }

        if (map[x][y] == -101) {
            return false;
        }
        return true;
    }

}