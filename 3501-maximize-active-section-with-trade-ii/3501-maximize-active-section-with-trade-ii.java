class Solution {
    void buildSegmentTree(int i, int l, int r, int[] segmentTree, int[] arr) {
        if (l == r) {
            segmentTree[i] = arr[l];
            return; 
        }
        int mid = l + (r - l)/2;
        buildSegmentTree(2 * i + 1, l, mid, segmentTree, arr);
        buildSegmentTree(2 * i + 2, mid + 1, r, segmentTree, arr);
        segmentTree[i] = Math.max(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);
    }
    int[] constructST(int[] arr, int n) {
        int[] segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, segmentTree, arr);
        return segmentTree;
    }

    int querySegmentTree(int start, int end, int i, int l, int r, int[] segmentTree) {
        if (l > end || r < start) {
            return Integer.MIN_VALUE;
        }

        if (l >= start && r <= end) {
            return segmentTree[i];
        }

        int mid = l + (r - l)/2;
        return Math.max(querySegmentTree(start, end, 2 * i + 1, l, mid, segmentTree),
                    querySegmentTree(start, end, 2 * i + 2, mid + 1, r, segmentTree));
    }

    int RMQ(int[] st, int n, int a, int b) {
        return querySegmentTree(a, b, 0, 0, n - 1, st);
    }

    // First index k with arr[k] >= key
    int lowerBound(int[] arr, int len, int key) {
        int lo = 0, hi = len;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (arr[mid] < key)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    // First index k with arr[k] > key
    int upperBound(int[] arr, int len, int key) {
        int lo = 0, hi = len;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (arr[mid] <= key)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();

        int activeCount = 0;
        for (int k = 0; k < n; k++) {
            if (s.charAt(k) == '1')
                activeCount++;
        }

        // scan zero-blocks, records where each one sits
        int[] blockStart = new int[n];
        int[] blockEnd = new int[n];
        int i = 0;
        int m = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                int start = i;
                while (i < n && s.charAt(i) == '0') i++;
                blockStart[m] = start;
                blockEnd[m] = i - 1;
                m++;
            } else {
                i++;
            }
        }

        //If there is only one block of zeros
        //example : s = "11000011" , answer = simply count of 1s "activeCount"
        if (m < 2) {
            List<Integer> ans = new ArrayList<>();
            for (int k = 0; k < queries.length; k++)
                ans.add(activeCount);
            return ans;
        }

        int[] blockSize = new int[m];
        for (int k = 0; k < m; k++) {
            blockSize[k] = blockEnd[k] - blockStart[k] + 1;
        }

        // pairSum[k] = blockSize[k] + blockSize[k+1], gain from activating adjacent blocks
        int N = m - 1; //This many pair sum will be there in pairSum

        int[] pairSum = new int[N];
        for (int k = 0; k < N; k++) {
            pairSum[k] = blockSize[k] + blockSize[k + 1];
        }

        int[] st = constructST(pairSum, N);
        List<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            // First block
            int low = lowerBound(blockEnd, m, l);
            // Last Block
            int high = upperBound(blockStart, m, r) - 1;

            int maxPairSum = 0;
            if (low < high) {
                int firstLen = blockEnd[low] - Math.max(blockStart[low], l) + 1;
                int lastLen = Math.min(r, blockEnd[high]) - blockStart[high] + 1;

                if (high - low == 1) { //Exactly two blocks only
                    maxPairSum = firstLen + lastLen;
                } else {
                    int pair1 = firstLen + blockSize[low + 1];
                    int pair2 = lastLen + blockSize[high - 1];
                    int rmqMaxPairSum = (low + 1 <= high - 2) ? RMQ(st, N, low + 1, high - 2) : 0;
                    maxPairSum = Math.max (pair1, Math.max(pair2, rmqMaxPairSum));
                }
            }
            res.add(maxPairSum + activeCount);
        }
        return res;
    }
}