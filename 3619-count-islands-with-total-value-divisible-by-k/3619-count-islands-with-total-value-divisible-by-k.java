class Solution {
    int n, m;
    public int countIslands(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    long sum = dfs(i, j, grid);
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public long dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 0L;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        long sum = 0L;
        sum += grid[i][j];
        grid[i][j] = 0;
        sum += dfs(i - 1, j, grid);
        sum += dfs(i + 1, j, grid);
        sum += dfs(i, j - 1, grid);
        sum += dfs(i, j + 1, grid);
        return sum;
    }
}