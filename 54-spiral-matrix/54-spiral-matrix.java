class Solution {
    int[] dx = { 0, 1, 0, -1 };
    int[] dy = { 1, 0, -1, 0 };
    int d = 0;

    public List<Integer> spiralOrder(int[][] m) {

        int x = 0;
        int y = 0;
        List<Integer> ans = new ArrayList<>();

        while (isRange(m, x, y) && m[x][y] != -101) {
            ans.add(m[x][y]);
            m[x][y] = -101;

            int tempNx = x + dx[d];
            int tempNy = y + dy[d];

            if (!isMoveable(m, tempNx, tempNy)) {
                d = (d + 1) % 4;
            }

            x = x + dx[d];
            y = y + dy[d];
        }

        return ans;
    }

    private boolean isMoveable(int[][] m, int x, int y) {
        if (!isRange(m, x, y)) {
            return false;
        }

        if (m[x][y] == -101) {
            return false;
        }

        return true;
    }

    private boolean isRange(int[][] m, int x, int y) {
        if (x >= m.length || x < 0) {
            return false;
        }

        if (y >= m[0].length || y < 0) {
            return false;
        }
        return true;
    }

}