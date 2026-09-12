class Solution {
    int n;
    List<Integer> nextIdx;

    class Node {
        long score = -1;
        List<Integer> idxs = new ArrayList<>();
    }
    Node[][] dp;

    int findNext(List<List<Integer>> intervals, int r) {
        int lo = 0;
        int hi = n - 1;
        int res = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (intervals.get(mid).get(0) > r) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        n = intervals.size();
        for(int i = 0; i < n; i++) {
            intervals.get(i).add(i);
        }
        intervals.sort((m, n) -> Integer.compare(m.get(0), n.get(0)));
        nextIdx = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int r = intervals.get(i).get(1);
            nextIdx.add(findNext(intervals, r));
        }

        final int K = 4;
        dp = new Node[n + 1][K + 1];
        for (Node[] d : dp) {
            Arrays.fill(d, new Node());
        }
        return solve(intervals, 0, K).idxs.stream().mapToInt(Integer::intValue).toArray();
    }

    Node solve(List<List<Integer>> intervals, int i, int k) {
        if (k == 0 || i >= n) {
            return new Node();
        }
        if (dp[i][k].score != -1) {
            return dp[i][k];
        }

        // skip interval i
        Node skip = solve(intervals, i + 1, k);

        int weight = intervals.get(i).get(2);
        int idx = intervals.get(i).get(3);
        int j = nextIdx.get(i);
        // take interval i
        Node temp = solve(intervals, j, k - 1);
        Node take = new Node();
        take.score = temp.score + weight;
        take.idxs = new ArrayList<>();
        take.idxs.addAll(temp.idxs);
        take.idxs.add(idx);
        Collections.sort(take.idxs);

        Node result;
        if (skip.score > take.score) {
            result = skip;
        } else if (skip.score < take.score) {
            result = take;
        } else {
            result = isLexSmaller(skip.idxs, take.idxs) ? skip : take;
        }
        dp[i][k] = result;
        return result;
    }

    boolean isLexSmaller(List<Integer> a, List<Integer> b) {
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            if (a.get(i) != b.get(i)) {
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }
}