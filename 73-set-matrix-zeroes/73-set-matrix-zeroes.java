class Solution {

    int[] dx = new int[] { 1, -1, 0, 0 };
    int[] dy = new int[] { 0, 0, -1, 1 };

    public void setZeroes(int[][] m) {
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    list.add(new Node(i, j));
                }
            }
        }

        int size = list.size();

        for (int i = 0; i < size; i++) {
            Node node = list.get(i);

            for (int j = 0; j < 4; j++) {
                int nx = node.x + dx[j];
                int ny = node.y + dy[j];

                while (isRange(m, nx, ny)) {
                    m[nx][ny] = 0;
                    nx += dx[j];
                    ny += dy[j];
                }
            }
        }

        return;
    }

    private boolean isRange(int[][] m, int x, int y) {
        if (x < 0 || x >= m.length) {
            return false;
        }

        if (y < 0 || y >= m[0].length) {
            return false;
        }

        return true;
    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}