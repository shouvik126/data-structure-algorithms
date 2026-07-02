class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Deque<int[]> deq = new LinkedList<>();
        int[][] result = new int[m][n];
        Arrays.stream(result).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));

        result[0][0] = grid.get(0).get(0);
        deq.addFirst(new int[]{0, 0});

        while (!deq.isEmpty()) {
            int[] cur = deq.poll();
            int cur_i = cur[0];
            int cur_j = cur[1];

            for (int[] dir : directions) {
                int new_i = cur_i + dir[0];
                int new_j = cur_j + dir[1];

                if (new_i < 0 || new_i >= m || new_j < 0 || new_j >= n) continue;

                if (result[new_i][new_j] > result[cur_i][cur_j] + grid.get(new_i).get(new_j)) {
                    result[new_i][new_j] = result[cur_i][cur_j] + grid.get(new_i).get(new_j);

                    if (grid.get(new_i).get(new_j) == 0) {
                        deq.addFirst(new int[]{new_i, new_j});
                    } else {
                        deq.addLast(new int[]{new_i, new_j});
                    }
                }

            }
        }

        int x = result[m - 1][n - 1];
        return health - x >= 1;
    }
}