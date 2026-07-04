class Solution {
    int result = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            adjList.computeIfAbsent(u, x -> new ArrayList<int[]>()).add(new int[]{v, w});
            adjList.computeIfAbsent(v, x -> new ArrayList<int[]>()).add(new int[]{u, w});
        }

        
        boolean[] visited = new boolean[n + 1];
        dfs(1, visited, adjList);
        return result;
    }

    public void dfs(int u, boolean[] visited, Map<Integer, List<int[]>> adjList) {
        visited[u] = true;

        for (int[] adj : adjList.getOrDefault(u, new ArrayList<>())) {
            int v = adj[0];
            int w = adj[1];
            result = Math.min(result, w);

            if (!visited[v]) {
                dfs(v, visited, adjList);
            }
        }
    }
}