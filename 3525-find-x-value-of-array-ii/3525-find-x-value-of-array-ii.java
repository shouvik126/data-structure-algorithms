//Approach (Segment Tree + concept of Find X Value of Array I
//T.C : O((n + q*logn) * k)   [Build = O(n*k), each Update/Query = O(k*logn)]
//S.C : O(n*k)   [segment tree storage, since each node stores an array of size k]
class Node {
    int[] count = new int[5];
    int prod = 0;
}
class SegmentTree {
    int n, k;
    Node[] segTree;
    SegmentTree(int[] nums, int k) {
        this.n = nums.length;
        this.k = k;
        segTree = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            segTree[i] = new Node();
        }
        build(0, 0, n - 1, nums);
    }
    void build(int i, int l, int r, int[] nums) {
        if (l == r) {
            leafNode(i, nums[l]);
            return;
        }
        int mid = l + (r - l)/2;
        build(2 * i + 1, l, mid, nums);
        build(2 * i + 2, mid + 1, r, nums);
        segTree[i] = mergeNode(segTree[2 * i + 1], segTree[2 * i + 2]);
    }
    void leafNode(int i, int val) {
        for (int x = 0; x < k; x++) {
            segTree[i].count[x] = 0;
        }
        int r = val % k;
        segTree[i].count[r] = 1;
        segTree[i].prod = r;
    }
    Node mergeNode(Node left, Node right) {
        Node result = new Node();
        result.prod = (left.prod * right.prod) % k;
        for (int x = 0; x < k; x++) {
            result.count[x] = left.count[x];
        }
        for (int x = 0; x < k; x++) {
            int newRem = (left.prod * x) % k;
            result.count[newRem] += right.count[x];
        }
        return result;
    }
    void update(int index, int value) {
        segTreeUpdate(0, 0, n - 1, index, value);
    }
    void segTreeUpdate(int i, int l, int r, int index, int value) {
        if (l == r ){
            leafNode(i, value);
            return;
        }
        int mid = l + (r - l)/2;
        if (index <= mid) {
            segTreeUpdate(2 * i + 1, l, mid, index, value);
        } else {
            segTreeUpdate(2 * i + 2, mid + 1, r, index, value);
        }
        segTree[i] = mergeNode(segTree[2 * i + 1], segTree[2 * i + 2]);
    }
    Node query(int start, int end) {
        return segTreeQuery(start, end, 0, 0,n - 1);
    }
    Node segTreeQuery(int start, int end, int i, int l, int r) {
        if (l >= start && r <= end) {
            return segTree[i];
        }
        int mid = l + (r - l)/2;
        if (end <= mid) {
            return segTreeQuery(start, end, 2 * i + 1, l, mid);
        }
        if(start > mid) {
            return segTreeQuery(start, end, 2 * i + 2, mid + 1, r);
        }
        Node left = segTreeQuery(start, end, 2 * i + 1, l, mid);
        Node right = segTreeQuery(start, end, 2 * i + 2, mid + 1, r);
        return mergeNode(left, right);
    }
}
class Solution {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree seg = new SegmentTree(nums, k);
        int[] res = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int index = query[0];
            int value = query[1];
            int start = query[2];
            int x = query[3];
            
            seg.update(index, value);
            Node no = seg.query(start, n - 1);
            res[idx] = no.count[x];
            idx++;
        }
        return res;
    }
}