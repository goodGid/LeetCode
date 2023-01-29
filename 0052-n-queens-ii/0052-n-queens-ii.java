class Solution {
    private int ans = 0;
    private int[][] visit;

    public int totalNQueens(int n) {
        visit = new int[n][n];
        dfs(n, 0, 0);
        return ans;
    }

    private void dfs(int n, int stLine, int cnt) {
        if (cnt == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[stLine][i] == 0) {
                visit(n, stLine, i);
                cnt++;
                dfs(n, stLine + 1, cnt);
                unVisit(n, stLine, i);
                cnt--;
            }
        }
    }

    private void visit(int n, int x, int y) {
        visit[x][y]--;
        for (int i = 0; i < n; i++) {
            visit[x][i]++;
        }

        for (int i = 0; i < n; i++) {
            visit[i][y]++;
        }

        for (int i = 1; i < n; i++) {
            if (x + i >= n || y + i >= n) {
                break;
            }
            visit[x + i][y + i]++;
        }

        for (int i = 1; i < n; i++) {
            if (x - i < 0 || y - i < 0) {
                break;
            }
            visit[x - i][y - i]++;
        }

        for (int i = 1; i < n; i++) {
            if (x + i >= n || y - i < 0) {
                break;
            }
            visit[x + i][y - i]++;
        }

        for (int i = 1; i < n; i++) {
            if (x - i < 0 || y + i >= n) {
                break;
            }
            visit[x - i][y + i]++;
        }
    }

    private void unVisit(int n, int x, int y) {
        visit[x][y]++;
        for (int i = 0; i < n; i++) {
            visit[x][i]--;
        }

        for (int i = 0; i < n; i++) {
            visit[i][y]--;
        }

        for (int i = 1; i < n; i++) {
            if (x + i >= n || y + i >= n) {
                break;
            }
            visit[x + i][y + i]--;
        }

        for (int i = 1; i < n; i++) {
            if (x - i < 0 || y - i < 0) {
                break;
            }
            visit[x - i][y - i]--;
        }

        for (int i = 1; i < n; i++) {
            if (x + i >= n || y - i < 0) {
                break;
            }
            visit[x + i][y - i]--;
        }

        for (int i = 1; i < n; i++) {
            if (x - i < 0 || y + i >= n) {
                break;
            }
            visit[x - i][y + i]--;
        }
    }

    private void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visit[i][j] + "");
            }
            System.out.println();
        }
        System.out.println();
    }

}
