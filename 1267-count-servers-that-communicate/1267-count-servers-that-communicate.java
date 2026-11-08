class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] idxRowCount = new int[n];
        int[] idxColCount = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    idxRowCount[i]++;
                    idxColCount[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && (idxRowCount[i] > 1 || idxColCount[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}