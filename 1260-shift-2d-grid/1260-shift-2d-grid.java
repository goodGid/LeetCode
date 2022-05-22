class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        int xl = grid.length;
        int yl = grid[0].length;
        int[][] list = new int[xl][yl];

        while (k-- > 0) {
            for (int i = 0; i < xl; i++) {
                for (int j = 0; j < yl; j++) {
                    int val = grid[i][j];
                    if (isRange(grid, i, j + 1)) {
                        list[i][j + 1] = val;
                    } else if (i + 1 < xl) {
                        list[i + 1][0] = val;
                    } else {
                        list[0][0] = val;
                    }
                }
            }

            copy(grid, list);
        }

        for (int i = 0; i < xl; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < yl; j++) {
                ans.get(i).add(grid[i][j]);
            }
        }

        return ans;
    }

    private boolean isRange(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) {
            return false;
        }

        if (y < 0 || y >= grid[0].length) {
            return false;
        }
        return true;
    }

    private void copy(int[][] grid, int[][] list) {
        int xl = grid.length;
        int yl = grid[0].length;

        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                grid[i][j] = list[i][j];
            }
        }
    }

    private void print(int[][] grid) {
        int xl = grid.length;
        int yl = grid[0].length;

        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                int val = grid[i][j];
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}