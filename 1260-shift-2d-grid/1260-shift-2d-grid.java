class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        for (int z = 1; z <= k; z++) {
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1 && j == n - 1) {
                        temp[0][0] = grid[i][j];
                    } else if (j == n - 1) {
                        temp[i + 1][0] = grid[i][j];
                    } else {
                        temp[i][j + 1] = grid[i][j];
                    }
                }
            }
            grid = temp;
        }
        List<List<Integer>> ans = Arrays.stream(grid)
            .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList()))
            .collect(Collectors.toList());
        return ans;
    }
}