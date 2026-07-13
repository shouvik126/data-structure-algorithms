class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            int ele = q.poll();
            if (ele > high)
                break;
            if (ele >= low) {
                ans.add(ele);
            }
            int lastDigit = ele % 10;
            if (lastDigit + 1 <= 9)
                q.add((ele * 10) + lastDigit + 1);
        }
        return ans;
    }
}