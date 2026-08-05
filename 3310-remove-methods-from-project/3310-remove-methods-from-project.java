class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        boolean[] sus = new boolean[n];
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
    
        for (int[] inv : invocations) {
            indegree[inv[1]]++;
            adjList.compute(inv[0], (key, v) -> {
                if (v == null)
                    v = new ArrayList<>();

                v.add(inv[1]);
                return v; 
            });
        }
        boolean[] visited = new boolean[n];
        dfs(adjList, sus, indegree, visited, k);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!sus[i]) {
                ans.add(i);
            } else {
                if (indegree[i] > 0) {
                    return IntStream.range(0, n)
                    .boxed()
                    .collect(Collectors.toList());
                }
            }
        }
        return ans;
    }
    public void dfs(Map<Integer, List<Integer>>adjList, boolean[] sus, int[] indegree, boolean[] visited, int k) {
        if (visited[k]){
            return;
        }
        visited[k] = true;
        sus[k] = true;
        
        if (adjList.get(k) != null) {
            for (int i : adjList.get(k)) {
                if (indegree[i] > 0) {
                    indegree[i]--;
                }
                dfs(adjList, sus, indegree, visited, i);
            }
        }
    }
}