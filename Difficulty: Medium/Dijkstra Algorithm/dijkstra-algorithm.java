class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        result[src] = 0;
        pq.offer(new int[]{0, src});
        
        Map<Integer, List<int[]>> map = new HashMap<>();
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            map.computeIfAbsent(u, x -> new ArrayList<int[]>()).add(new int[]{v, w});
            map.computeIfAbsent(v, x -> new ArrayList<>())
            .add(new int[]{u, w});
        }
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            int curr_v = curr[1];
            int curr_w = curr[0];
            
            if (curr_w > result[curr_v])
                continue;
            
            for (int[] edge : map.getOrDefault(curr_v, new ArrayList<>())) {
                int v = edge[0];
                int w = edge[1];
                
                if (curr_w + w < result[v]) {
                    result[v] = curr_w + w;
                    pq.offer(new int[]{curr_w + w, v});
                }
            }
        }
        return result;
    }
}