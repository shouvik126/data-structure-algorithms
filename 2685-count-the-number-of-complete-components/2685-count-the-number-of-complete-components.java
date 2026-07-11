class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        int result = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            int[] info = new int[2];
            dfs(i, adj, visited, info);
            int v = info[0];
            int e = info[1];
            if ((v * (v - 1)) == e)
                result++;
        }
        return result;
    }

    public void dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited, int[] info) {
        info[0]++;
        info[1] += adj.getOrDefault(node, new ArrayList<>()).size();
        visited[node] = true;

        for (int v : adj.getOrDefault(node, new ArrayList<>())) {
            if (!visited[v]) {
                dfs(v, adj, visited, info);
            }
        }
    }
}