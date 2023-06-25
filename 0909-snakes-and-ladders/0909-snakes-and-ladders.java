class Solution {
    public int snakesAndLadders(int[][] board) {
        boolean leftToRight = true;
        int idx = 0;

        int size = board.length;
        int[] map = new int[size * size];

        for (int i = size - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < size; j++) {
                    map[idx++] = board[i][j];
                }
            } else {
                for (int j = size - 1; j >= 0; j--) {
                    map[idx++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<Node> q = new LinkedList<>();
        int[] visit = new int[size * size];

        q.add(new Node(0, 0));
        visit[0] = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int curr = node.idx;
            int val = node.val;

            if (curr == size * size - 1) {
                return val;
            }

            for (int i = 1; i <= 6; i++) {
                int nPos = curr + i;

                if (nPos >= size * size) {
                    continue;
                }

                if (map[nPos] != -1) {
                    nPos = map[nPos] - 1;
                }

                if (visit[nPos] == 0) {
                    q.add(new Node(nPos, val + 1));
                    visit[nPos] = 1;
                }
            }
        }
        return -1;
    }

    class Node {
        int idx;
        int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}