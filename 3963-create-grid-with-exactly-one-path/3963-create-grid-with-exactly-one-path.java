class Solution {
    public String[] createGrid(int m, int n) {
        String topRow = ".".repeat(n);
        String others = "#".repeat(n - 1) + ".";
        String[] ans = new String[m];
        ans[0] = topRow;
        for (int i = 1; i < m; i++) {
            ans[i] = others;
        }
        return ans;
    }
}